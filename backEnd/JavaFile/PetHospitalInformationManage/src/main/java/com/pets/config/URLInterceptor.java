package com.pets.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.main.util.JWTUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        // 权限认证并填入
        String token = request.getHeader("Auth");
        System.out.println("openID:" + request.getHeader("X-WX-OPENID") +
                " AppID:" + request.getHeader("X-WX-APPID") +
                " unionID:" + request.getHeader("X-WX-UNIONID") +
                " ENV:" + request.getHeader("X-WX-ENV") +
                " Source:" + request.getHeader("X-WX-SOURCE") +
                " IP:" + request.getHeader("X-Forwarded-For")
        );
        //测试获取Header
        if (path.matches("/pwd/[a-zA-Z0-9_]{1,}") || path.equals("/")) {
            //获取token放行
            return true;
        }
        if (token != null && token.length() > 0 && com.main.util.JWTUtil.verifyToken(token) == 0) {
            request.setAttribute("Auth", JWTUtil.parseToken(token).get("Auth") == null ? 1 : JWTUtil.parseToken(token).get("Auth"));
            return true;
        }
        JSONObject resp = new JSONObject();
        resp.put("msg", "未登录或登录过期");
        resp.put("code", 1);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(resp.toJSONString());
        return false;
//        if (path.matches("/[a-zA-Z0-9_]{1,}/delete")) {
////            JSONObject resp = new JSONObject();
////            resp.put("msg", "该功能被禁用");
////            resp.put("code", 1);
////            response.setContentType("text/html;charset=utf-8");
////            response.getWriter().println(resp.toJSONString());
//
////            response.sendRedirect(request.getContextPath() + "/prohibit");
//            return true;
//            // 或者 return false; 禁用某些请求
//        } else {
//            return true;
//        }
    }
}