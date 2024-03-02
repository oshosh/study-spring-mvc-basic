package hello.servlet.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

  @Override // ctrl + o -> service 잠금 선택
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("HelloServlet.service"); //soutm
    System.out.println("request = " + request); // soutv
    System.out.println("response = " + response); // soutv
  }
}
