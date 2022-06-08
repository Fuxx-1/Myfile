package cn.lab.recruitsystem.Controller;

import cn.lab.recruitsystem.Util.JWTUtil;
import cn.lab.recruitsystem.Util.ReturnUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-29 21:32
 */
@Controller
@ResponseBody
public class TestController {

    @RequestMapping("/")
    public String index() {
        return ReturnUtil.returnMsg("Welcome to RecruitSystem", 0, null);
    }

    @RequestMapping("/testToken")
    public String testToken(HttpServletRequest request) {
        if (JWTUtil.verifyToken(request.getHeader("access_token")) == 0) {
            return ReturnUtil.returnMsg("Token有效", 0, null);
        } else {
            return ReturnUtil.returnMsg("Token无效", -1, null);
        }
    }
}
