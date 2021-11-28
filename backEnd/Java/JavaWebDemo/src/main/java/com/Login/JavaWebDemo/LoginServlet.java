package com.Login.JavaWebDemo;

import com.alibaba.fastjson.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * @create: 2021-05-23 20:55
 **/
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    public static final String USER = "Demo";
    public static final String PassWd = "200224";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://149.28.227.81:3306/datatest";
    Connection con = null;
    Statement stmt = null;

    //    stmt = conn.createStatement();
//    String sql;
//    sql = "SELECT ID, NAME, URL FROM runoob where name = '菜鸟教程'";
//    ResultSet rs = stmt.executeQuery(sql);

    private String signup(String username, String passwd) {
        ResultSet temp = null;
        try {
            temp = stmt.executeQuery("select passwd from UserForTest where user = '" + username + "'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (temp.next()) {
                return "用户已存在";
            } else {
                stmt.execute("INSERT INTO UserForTest VALUES ('" + username + "','" + passwd + "')");
                return "注册成功！";
            }
        } catch (Exception throwable) {
            throwable.printStackTrace();
            return "false";
        }
    }


    private String login(String username, String passwd) {
        ResultSet pass = null;
        try {
            pass = stmt.executeQuery("select passwd from UserForTest where user = '" + username + "'");
            if (pass.next()) {
                if (passwd.equals(pass.getString("passwd"))) {
                    return "登录成功！";
                } else {
                    return "密码错误";
                }
            } else {
                return "用户不存在";
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return "";
    }

    @Override
    public void init() throws ServletException {
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PassWd);
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        try {
            if (con != null) {
                con.close();
            }
            if (con != null) {
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject info = new JSONObject();
        if ("true".equals(req.getParameter("signup"))) {
            System.out.println("signup");
            System.out.println(req.getParameter("username"));
            System.out.println(req.getParameter("passwd"));
            info.put("info", signup(req.getParameter("username"), req.getParameter("passwd")));
        }
        if ("true".equals(req.getParameter("login"))) {
            System.out.println("login");
            System.out.println(req.getParameter("username"));
            System.out.println(req.getParameter("passwd"));
            info.put("info", login(req.getParameter("username"), req.getParameter("passwd")));
        }
        resp.setContentType("text/json; charset = utf-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.getWriter().println(info.toJSONString());
    }
}
