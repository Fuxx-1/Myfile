package ltd.newimg.sessioncookie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");

        if (username.equalsIgnoreCase("zhangsan")) {
            res.getWriter().println("用户名或密码错误！");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            res.sendRedirect("./1.jsp");
        }

    }
}

