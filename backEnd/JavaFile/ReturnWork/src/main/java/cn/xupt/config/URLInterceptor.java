package cn.lab.recruitsystem.config;

import cn.lab.recruitsystem.Util.HttpRequestUtil;
import cn.lab.recruitsystem.Util.JWTUtil;
import cn.lab.recruitsystem.Util.ReturnUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * URL拦截，做对应处理
 */
@Component
public class URLInterceptor implements HandlerInterceptor {


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
        String token = request.getHeader("Auth");
// 测试获取Header
//        System.out.println("openID:" + request.getHeader("X-WX-OPENID") +
//                " AppID:" + request.getHeader("X-WX-APPID") +
//                " unionID:" + request.getHeader("X-WX-UNIONID") +
//                " ENV:" + request.getHeader("X-WX-ENV") +
//                " Source:" + request.getHeader("X-WX-SOURCE") +
//                " IP:" + request.getHeader("X-Forwarded-For")
//        );
        //获取token放行
        if ((path.matches("/(pwd|user)/[a-zA-Z0-9_]{1,}") || path.equals("/"))) {
            //request.getHeader("X-WX-ENV") != null &&
            return true;
        }
        try {
            //Token筛选
            if (token != null && token.length() > 0 && JWTUtil.verifyToken(token) == 0) {
                int Auth = (int) JWTUtil.parseToken(token).get("Auth");
                // 获取Auth
                //delete筛选
                if (path.matches("/[a-zA-Z0-9_]{1,}/delete")) {
                    if (Auth >= 2) {
                        // JWTUtil.parseToken(token).get("openid").equals(request.getHeader("X-WX-OPENID"))
                        return true;
                    } else {
                        response.getWriter().println(ReturnUtil.returnMsg("权限不足", 2, null));
                        return false;
                    }
                }
                // 默认筛选
                if (Auth >= 1) {
                    // JWTUtil.parseToken(token).get("openid").equals(request.getHeader("X-WX-OPENID"))
                    return true;
                } else {
                    response.getWriter().println(ReturnUtil.returnMsg("权限不足", 2, null));
                    return false;
                }
            }
        } catch (Exception e) {
//            System.out.println(e);
            response.getWriter().println(ReturnUtil.returnMsg("请重启小程序，如问题仍存在请联系管理员", 1, null));
            return false;
        }
        response.getWriter().println(ReturnUtil.returnMsg("请重启小程序，如问题仍存在请联系管理员", 1, null));
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
            Logger.getLogger("c.p.c.URLInterceptor").warning(
                    "openID:" + request.getHeader("X-WX-OPENID") +
                            " AppID:" + request.getHeader("X-WX-APPID") +
                            " ENV:" + request.getHeader("X-WX-ENV") +
                            " StatusCode:" + response.getStatus() +
                            " ServletPath:" + request.getServletPath() +
                            " Param:" + JSON.toJSONString(request.getParameterMap())
                            + " RequestBody:" + HttpRequestUtil.getBodyString(request)
            );
        } else {
            Logger.getLogger("c.p.c.URLInterceptor").info(
                    "openID:" + request.getHeader("X-WX-OPENID") +
                            " AppID:" + request.getHeader("X-WX-APPID") +
                            " ENV:" + request.getHeader("X-WX-ENV") +
                            " StatusCode:" + response.getStatus() +
                            " ServletPath:" + request.getServletPath() +
                            " Param:" + JSON.toJSONString(request.getParameterMap())
                            + " RequestBody:" + HttpRequestUtil.getBodyString(request)
            );
        }
//                System.out.println("openID:" + request.getHeader("X-WX-OPENID") +
//                " AppID:" + request.getHeader("X-WX-APPID") +
//                " ENV:" + request.getHeader("X-WX-ENV") + request.getServletPath()
//        );
    }

//    private String getBodyData(HttpServletRequest request) {
//        StringBuffer data = new StringBuffer();
//        String line = null;
//        BufferedReader reader = null;
//        try {
//            reader = request.getReader();
//            while (null != (line = reader.readLine()))
//                data.append(line);
//        } catch (IOException e) {
//        } finally {
//        }
//        return data.toString();
//    }
}