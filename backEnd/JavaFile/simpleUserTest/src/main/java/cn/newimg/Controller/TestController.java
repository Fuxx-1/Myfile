package cn.newimg.Controller;

import cn.newimg.Util.ReturnUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return ReturnUtil.returnMsg("Welcome to simpleUserTamplate", 0, null);
    }

}
