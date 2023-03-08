package org.tomcat.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class RandomServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        res.setCharacterEncoding("utf-8");
        PrintWriter out = res.getWriter();
        out.println(
                "<html>" +
                    "<head>" +
                        "<title>随机数</title>" +
                    "</head>" +
                    "<body>" +
                        "<h1>" + "随机数" + "</h1>" +
                        "<h2>" + new Random().nextInt(10) + "</h2>" +
                    "</body>" +
                "</html>"
        );
    }
}
