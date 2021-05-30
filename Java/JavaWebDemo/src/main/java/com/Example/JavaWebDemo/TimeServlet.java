package com.easxample.JavaWebDemo;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @create: 2021-05-26 20:18
 **/
@WebServlet("/Time")
public class TimeServlet extends HttpServlet {
    private int i = 1;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date now = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        resp.setContentType("text/json; charset=utf-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");

        System.out.println("该服务器被第" + i++ + "次请求" + "、请求时间：" + ft.format(now));

        JSONObject returnObj = new JSONObject();
        returnObj.put("info", "这条信息表明成功从服务器获得返还值");
        returnObj.put("time", ft.format(now));
        resp.getWriter().println(returnObj.toJSONString());
    }
}
