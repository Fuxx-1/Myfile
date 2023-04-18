package ltd.newimg.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import ltd.newimg.exception.MyBlockExceptionHandler;
import ltd.newimg.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    @SentinelResource(value = "getUser", blockHandler = "blockGetUser")
    public String getUser() {
        return "getUser";
    }

    public String blockGetUser(BlockException e) {
        return "限流";
    }
}
