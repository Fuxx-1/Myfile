package com.easxample.JavaWebDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @create: 2021-05-26 20:14
 **/
@WebServlet("/Cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int flag = 0;
        final String name = "asdfsdgwdfsv";
        final SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //就觉乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        //输出流
        PrintWriter out = resp.getWriter();
        //判断Cookies是否存在
        javax.servlet.http.Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            out.write("您上次访问的时间是：");
            for (javax.servlet.http.Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    Date LatestLoginTime = new Date(Long.parseLong(cookie.getValue()));
                    out.write(ft.format(LatestLoginTime));
                    flag = 1;
                }
            }
        } else {
            out.write("First");
        }
        if (flag == 0) {
            out.write("First");
        }
        //服务器响应cookie
//        resp.addCookie(new Cookie(req.getParameter("username"),req.getParameter("passwd")));
        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie(name, String.valueOf(System.currentTimeMillis()));
        cookie.setMaxAge(1 * 60 * 60);
        resp.addCookie(cookie);
    }
}
