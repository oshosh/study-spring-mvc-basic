package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // [status-line]
    response.setStatus(HttpServletResponse.SC_OK);
//    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

    //[response-header]
//    response.setHeader("Content-Type", "text/plain;charset=utf-8");
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 캐시 무효화
    response.setHeader("Pragma", "no-cache"); // 과거 캐시 무효화
    response.setHeader("My-header", "hello");

    // [Header 편의 메서드]
//    content(response);

    // [Cookie 편의 메서드]
//    cookie(response);
    redirect(response);

    // [message body]
    PrintWriter writer = response.getWriter();
    writer.println("ok 완료입니다.");
  }

  private void redirect(HttpServletResponse response) throws IOException {
    // Status Code 302
    // Location : /basic/hello-form.html

//    response.setStatus(HttpServletResponse.SC_FOUND);
//    response.sendRedirect("Location", "/basic/hello-form.html");

    response.sendRedirect("/basic/hello-form.html"); // 302, location: /basic/hello-form.html
  }

  private void content(HttpServletResponse response) {
    response.setContentType("text/plain");
    response.setCharacterEncoding("utf-8");
  }

  private void cookie(HttpServletResponse response) {
    Cookie cookie = new Cookie("myCookie", "good");
    cookie.setMaxAge(600);
    response.addCookie(cookie);
  }

}
