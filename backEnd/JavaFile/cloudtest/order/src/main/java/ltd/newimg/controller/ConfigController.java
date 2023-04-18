package ltd.newimg.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {
    @Value("${NacosTest.testA}")
    public String a;

    @Value("${NacosTest.testB}")
    public String b;

    @Value("${NacosTest.testC}")
    public String c;

    @Value("${NacosTest.testD}")
    public String d;

    @RequestMapping("/show")
    public String show() {
        return "a: " + a +
                "; b: " + b +
                "; c: " + c +
                "; d: " + d +
                ";";
    }
}
