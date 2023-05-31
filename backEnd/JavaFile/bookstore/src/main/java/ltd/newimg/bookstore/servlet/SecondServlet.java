package ltd.newimg.bookstore.servlet;

import ltd.newimg.bookstore.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        Student student = (Student) getServletContext().getAttribute("student");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter respWriter = resp.getWriter();
        respWriter.println("<html><head><title>SecondServlet</title></head><body><table>" +
                "<tr><td>Uid: </td><td>" + student.getUid() + "</td>" +
                "<tr><td>Name: </td><td>" + student.getName() + "</td>" +
                "</table><a href=\"./\">返回</a>" +
                "</body></html>"
        );
    }
}

