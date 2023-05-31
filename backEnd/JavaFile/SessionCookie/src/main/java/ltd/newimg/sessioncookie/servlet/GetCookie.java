package ltd.newimg.sessioncookie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getCookie")
public class GetCookie extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie e : cookies) {
                if (e.getName().equalsIgnoreCase("id")) {
                    res.getWriter().println("您的id是：" + e.getValue());
                }
            }
        }
        res.getWriter().println("<a href=\"./addCookie\">addCookie</a>");
    }
}
