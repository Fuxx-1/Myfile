package ltd.newimg.booksystem.config;

import com.alibaba.fastjson.JSONObject;
import ltd.newimg.booksystem.Util.RedisUtil;
import ltd.newimg.booksystem.model.dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 请求开始时获取用户信息，并存在 ThreadLocal
        Cookie[] cookies = request.getCookies();
        UserDTO user = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    user = JSONObject.parseObject((String) redisUtil.getCacheObject(cookie.getValue()), UserDTO.class);
                }
            }
        }
        UserHolder.setUser(user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 请求结束时释放 ThreadLocal 中的用户信息
        UserHolder.remove();
    }
}
