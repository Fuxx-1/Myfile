package ltd.newimg.bookstore.servlet;

import ltd.newimg.bookstore.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Student student = new Student(req.getParameter("uid"), req.getParameter("name"));
        getServletContext().setAttribute("student", student);
        getServletContext().getRequestDispatcher("/second").forward(req, res);
    }
}

