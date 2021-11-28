package com.easxample.JavaWebDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @create: 2021-05-26 19:05
 **/
@WebServlet("/Session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //就觉乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        //得到Session
        HttpSession session = req.getSession();
        //给Session中存东西
        session.setAttribute("name","按时发大厦");
        //获取SessionId
        String sessionId = session.getId();
        //判断Session是不是新创建的
        if (session.isNew()) {
            resp.getWriter().write("Session创建成功，ID：" + sessionId);
        }
        //Session创建时做了什么？
        //用sessionId创建cookie
    }
}
