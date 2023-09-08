package ltd.newimg.booksystem.controller;

import ltd.newimg.booksystem.Util.ReturnUtil;
import ltd.newimg.booksystem.Util.en.ReturnCodeEnum;
import ltd.newimg.booksystem.config.UserHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {

    @GetMapping("")
    String queryBook() {
        if (UserHolder.getUser() != null) {
            return ReturnUtil.returnMsg(ReturnCodeEnum.SUCCESS, null);
        } else {
            return ReturnUtil.returnMsg(ReturnCodeEnum.SYSTEM_FAILED, null);
        }
    }
}
