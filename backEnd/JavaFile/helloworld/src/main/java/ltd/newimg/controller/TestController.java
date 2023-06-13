package ltd.newimg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/test1")
    public String test1() {
        return "test1";
    }

    @ResponseBody
    @RequestMapping("/test2")
    public String test2() {
        return "test2";
    }

    @RequestMapping("/test3")
    public String test(){
        return "index.html";
    }
}
