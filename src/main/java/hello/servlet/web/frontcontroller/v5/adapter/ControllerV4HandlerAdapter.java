package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
  @Override
  public boolean supports(Object handler) {
    return handler instanceof ControllerV4;
  }

  @Override
  public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
    ControllerV4 controller = (ControllerV4) handler;

    Map<String, String> paramMap = createParamMap(request);
    Map<String, Object> model = new HashMap<>();

    String viewName = controller.process(paramMap, model);

    ModelView mv = new ModelView(viewName);
    mv.setModel(model);

    return mv;
  }

  private static Map<String, String> createParamMap(HttpServletRequest request) {
    Map<String, String> paramMap = new HashMap<>();

    // 모든 전달된 파라메터의 key와 값으로 저장
    request.getParameterNames().asIterator()
        .forEachRemaining(paramName -> {
          String paramValue = request.getParameter(paramName);
          paramMap.put(paramName, paramValue);

          System.out.println("Parameter Name: " + paramName + ", Value: " + paramValue);
        });

    return paramMap;
  }
}
