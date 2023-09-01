//package ltd.newimg.booksystem.config;
//
//import com.alibaba.fastjson.JSONObject;
//import ltd.newimg.booksystem.Util.RedisUtil;
//import ltd.newimg.booksystem.model.dto.UserDTO;
//import ltd.newimg.booksystem.model.vo.UserVO;
//import org.springframework.context.annotation.ComponentScan;
//
//import javax.annotation.Resource;
//import javax.servlet.*;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//
//public class UserCostFilter implements Filter {
//
//    @Resource
//    RedisUtil redisUtil;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        Cookie[] cookies = httpServletRequest.getCookies();
//        UserDTO user = null;
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("id")) {
//                user = JSONObject.parseObject((String) redisUtil.getCacheObject(cookie.getValue()), UserDTO.class);
//            }
//        }
//        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
//        threadLocal.set(user);
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
