package cn.newimg.config;

import cn.newimg.Model.dto.AuthDto;
import cn.newimg.Util.HttpRequestUtil;
import cn.newimg.Util.JWTUtil;
import cn.newimg.Util.ReturnCodeEnum;
import cn.newimg.Util.ReturnUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * URL拦截，做对应处理
 */
@Component
public class URLInterceptor implements HandlerInterceptor {

    public static final String pathNotNeedAuth = "(/user/[a-zA-Z0-9_/]{0,})";
    public static final List<AuthDto> config = Arrays.asList(
            new AuthDto("/[a-zA-Z0-9_]{1,}/user[a-zA-Z0-9_/]{0,}", 1),
            new AuthDto("/[a-zA-Z0-9_]{1,}/admin[a-zA-Z0-9_/]{0,}", 2),
            new AuthDto("/[a-zA-Z0-9_]{1,}/super_admin[a-zA-Z0-9_/]{0,}", 3)
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
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        // 获取token
        response.setContentType("text/html;charset=utf-8");
        // 设置返回头
        String token = request.getHeader("access_token");
        // 无需权限的路径放行
        if (path.matches(pathNotNeedAuth)) {
            return true;
        }
        try {
            //Token筛选
            if (token != null && token.length() > 0 && JWTUtil.verifyToken(token) == 0) {
                int auth = (int) JWTUtil.parseToken(token).get("Auth");
                // 获取Auth
                // 权限筛选
                for (AuthDto authDto : config) {
                    if (path.matches(authDto.getRegex())) {
                        if (auth >= authDto.getAskedAuth()) {
                            return true;
                        } else {
                            response.getWriter().println(ReturnUtil.returnMsg(ReturnCodeEnum.ACCESS_DENIED, null));
                            return false;
                        }
                    }
                }
            }
        } catch (Exception e) {
            Logger.getLogger("c.l.r.c.URLInterceptor").warning(e.toString());
            response.getWriter().println(ReturnUtil.returnMsg(ReturnCodeEnum.ACCESS_DENIED, null));
            return false;
        }
        response.getWriter().println(ReturnUtil.returnMsg(ReturnCodeEnum.ACCESS_DENIED, null));
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
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (response.getStatus() != 200) {
            Logger.getLogger("c.l.r.c.URLInterceptor").warning(
                    " StatusCode:" + response.getStatus() +
                            " ServletPath:" + request.getServletPath() +
                            " Param:" + JSON.toJSONString(request.getParameterMap())
                            + " RequestBody:" + HttpRequestUtil.getBodyString(request)
            );
        } else {
            Logger.getLogger("c.l.r.c.URLInterceptor").info(
                    " StatusCode:" + response.getStatus() +
                            " ServletPath:" + request.getServletPath() +
                            " Param:" + JSON.toJSONString(request.getParameterMap())
                            + " RequestBody:" + HttpRequestUtil.getBodyString(request)
            );
        }
    }
}