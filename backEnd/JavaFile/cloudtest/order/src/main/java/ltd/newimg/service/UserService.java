package ltd.newimg.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import ltd.newimg.exception.MyBlockExceptionHandler;

public interface UserService {

    String getUser();
}
