package ltd.newimg.sessioncookie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/addCookie")
public class AddCookie extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=utf-8");
        String uuid = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("id", uuid);
        res.addCookie(cookie);
        res.getWriter().println("Send Over!");
        res.getWriter().println("<a href=\"./getCookie\">getCookie</a>");
    }
}
