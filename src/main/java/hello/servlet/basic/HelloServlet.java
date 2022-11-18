package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") // name :서블릿 이름, urlPatterns : URL매핑
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         // ctrl + o 자동 생성

        System.out.println("HelloServlet.service"); // soutm
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username"); //ctrl + alt + v, 요청하기
        System.out.println("username = " + username);

        //응답 메시지 보내기
        response.setContentType("text/plain"); //header 정보에 들어감
        response.setCharacterEncoding("utf-8"); //header 정보에 들어감
        response.getWriter().write("hello " + username); // http body에 내용이 들어감


    }
}
