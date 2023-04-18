package ltd.newimg.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import ltd.newimg.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    @Resource
    UserService userService;


    @RequestMapping("/test1")
    public String test1() {
        return "test1";
    }

    @RequestMapping("/test2")
    public String test2() {
        return "test2--" + userService.getUser();
    }

    @RequestMapping("/test3")
    public String test3() {
        return "test3--" + userService.getUser();
    }

    @RequestMapping("/test4")
    @SentinelResource(value = "test4", blockHandler = "flowBlockHandler")
    public String test4() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return "test4";
    }

    @RequestMapping("/err")
    @SentinelResource(value = "err", blockHandler = "flowBlockHandler")
    public String err() {
        if (new Random().nextInt(2) == 1) {
            throw new RuntimeException("RandomException");
        }
        return "test4";
    }

    public String flowBlockHandler(BlockException e, HttpServletResponse response) {
        response.setStatus(500);
        return new JSONObject(){{
            put("code", 100);
            put("msg", "服务降级了");
            put("data", e.toString());
        }}.toJSONString();
    }

    @RequestMapping("/test/getById/{id}")
    @SentinelResource(value = "getById", blockHandler = "flowBlockHandler")
    public String getById(@PathVariable Integer id) {
        return "getById-->" + id;
    }
}
