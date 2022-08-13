package ltd.newimg.config;

import com.alibaba.fastjson.JSON;

import ltd.newimg.model.DTO.AuthDTO;
import ltd.newimg.util.HttpRequestUtil;
import ltd.newimg.util.JWTUtil;
import ltd.newimg.util.ReturnUtil;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * URL拦截，做对应处理
 *
 * @author Fuxx-1@Github
 * @Description
 * @date 2022/07/21 13:53
 */
@Component
public class URLInterceptor implements HandlerInterceptor {

    private static final Integer NORMAL_STATUS = 200;

    public static final String PATH_NOT_NEED_AUTH = "";
    public static final List<AuthDTO> PATH_WITH_AUTH = Arrays.asList(
            new AuthDTO("/[a-zA-Z0-9_]{1,}/[a-zA-Z0-9_/]{0,}", 1)
//            , new AuthDTO("/[a-zA-Z0-9_]{1,}/admin[a-zA-Z0-9_/]{0,}", 2)
    );

    /**
     * 请求前置处理（后置处理同理）
     *
     * @param request
     * @param response
     * @param handler
     * @return boolean
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String path = request.getServletPath();
        // 设置返回头
        response.setContentType("text/html;charset=utf-8");
        // 无需权限的路径放行
        if (path.matches(PATH_NOT_NEED_AUTH)) {
            return true;
        }
        // 获取token
        String token = request.getHeader("access_token");
        try {
            // Token筛选
            if (token != null && token.length() > 0 && JWTUtil.verifyToken(token) == 0) {
                int auth = (int) JWTUtil.parseToken(token).get("Auth");
                // 获取Auth
                // 权限筛选
                for (AuthDTO authDto : PATH_WITH_AUTH) {
                    if (path.matches(authDto.getRegex())) {
                        if (auth >= authDto.getAskedAuth()) {
                            return true;
                        } else {
                            response.getWriter().println(ReturnUtil.returnMsg("权限不足", 100, null));
                            return false;
                        }
                    }
                }
            }
        } catch (Exception e) {
            Logger.getLogger("c.l.r.c.URLInterceptor").warning(e.toString());
            response.getWriter().println(ReturnUtil.returnMsg("请刷新网页，如问题仍存在请联系管理员", 1, null));
            return false;
        }
        response.getWriter().println(ReturnUtil.returnMsg("请刷新网页，如问题仍存在请联系管理员", 1, null));
        return false;
    }

    /**
     * 请求后置处理（后置处理同理）
     *
     * @param request
     * @param response
     * @param handler
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        if (response.getStatus() != NORMAL_STATUS) {
            Logger.getLogger("c.l.r.c.URLInterceptor").warning(
                    " StatusCode:" + response.getStatus() +
                            " ServletPath:" + request.getServletPath() +
                            " Param:" + JSON.toJSONString(request.getParameterMap())
                            + " RequestBody:" + HttpRequestUtil.getBodyString(request));
        } else {
            Logger.getLogger("c.l.r.c.URLInterceptor").info(
                    " StatusCode:" + response.getStatus() +
                            " ServletPath:" + request.getServletPath() +
                            " Param:" + JSON.toJSONString(request.getParameterMap())
                            + " RequestBody:" + HttpRequestUtil.getBodyString(request));
        }
    }
}