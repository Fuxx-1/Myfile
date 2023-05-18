package ltd.newimg;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Register extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        Reg reg = new Reg(req.getParameterMap());
        Logger logger = Logger.getLogger(String.valueOf(this.getClass()));
        logger.log(Level.INFO, reg.toString());
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        if (reg.hasDetail) {
            out.println(reg.name + "，您好，现在时间是：" +
                    new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "<br/>" +
                    "您的注册信息如下：<br/>" +
                    "姓名：" + reg.name + "<br/>" +
                    "性别：" + reg.gender + "<br/>" +
                    "邮箱：" + reg.email + "<br/>" +
                    "楼号：" + reg.room + "<br/>" +
                    "宿舍号：" + reg.roomDetail + "<br/>"
            );
        } else {
            out.println(reg.name + "，您好，现在时间是：" +
                    new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "<br/>" +
                    "您的注册信息如下：<br/>" +
                    "姓名：" + reg.name + "<br/>" +
                    "性别：" + reg.gender
            );
        }
    }


    @Data
    static public class Reg {
        String name;
        String password;
        String gender;
        Boolean hasDetail;
        String email;
        String room;
        String roomDetail;

        public Reg(Map<String, String[]> map) {
            this.name = map.get("name")[0];
            this.password = map.get("pwd")[0];
            this.gender = map.get("gender")[0].equals("M") ? "male" : "female";
            this.hasDetail = map.get("hasDetail")[0].equals("true");
            if (this.hasDetail) {
                this.email = map.get("email")[0];
                this.room = map.get("room")[0];
                this.roomDetail = map.get("roomDetail")[0];
            }
        }

        public String toString() {
            return JSONObject.toJSONString(this);
        }
    }
}
