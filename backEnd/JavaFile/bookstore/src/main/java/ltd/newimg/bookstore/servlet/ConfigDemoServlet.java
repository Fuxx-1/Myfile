package ltd.newimg.bookstore.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class ConfigDemoServlet extends HttpServlet {
    String servletName = null;
    ServletConfig servletConfig = null;
    String email = null;
    String telephone = null;

    @Override
    public void init() throws ServletException {
        servletConfig = getServletConfig();
        servletName = servletConfig.getServletName();
        email = servletConfig.getInitParameter("email");
        telephone = servletConfig.getInitParameter("telephone");
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        System.out.println(getServletContext().getInitParameter("email"));
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter respWriter = resp.getWriter();
        respWriter.println("<html><head><title>ConfigDemoServlet</title></head><body><table>" +
                "<tr><td>ServletName: </td><td>" + servletName + "</td>" +
                "<tr><td>email: </td><td>" + email + "</td>" +
                "<tr><td>telephone: </td><td>" + telephone + "</td>" +
                "</table></body></html>"
        );
    }
}

