package ltd.newimg.bookstore.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/info")
public class ServerInfoServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        ServletContext sc = getServletContext();
        Enumeration<String> attributeNames = sc.getAttributeNames();
        String name = "";
        while (attributeNames.hasMoreElements()) {
            name += (String)attributeNames.nextElement() + "、";
        }
        PrintWriter respWriter = resp.getWriter();
        respWriter.println("<html><head><title>获取服务器端信息</title></head><body>" +
                "<h2>服务器端信息：</h2><br/><table width=\"500\" border=\"1\">" +
                "<tr><td>站点名: </td><td>" + req.getServerName() + "</td>" +
                "<tr><td>端口号: </td><td>" + req.getServerPort() + "</td>" +
                "<tr><td>服务器类型: </td><td>" + sc.getServerInfo() + "</td>" +
                "<tr><td>支持Servlet版本: </td><td>" + sc.getMajorVersion() + "." + sc.getMinorVersion() + "</td>" +
                "<tr><td>服务器属性: </td><td>" + name + "</td>" +
                "</table></body></html>"
        );
    }
}

