package cn.newimg.Util;

import com.alibaba.fastjson.JSONObject;

public class ReturnUtil {

    public static String returnMsg(ReturnCodeEnum codeAndMsg, Object data) {
        JSONObject resp = new JSONObject();
        resp.put("msg", codeAndMsg.getCode());
        resp.put("code", codeAndMsg.getMsg());
        resp.put("data", data);
        return resp.toJSONString();
    }

    public static JSONObject returnObj(ReturnCodeEnum codeAndMsg, Object data) {
        JSONObject resp = new JSONObject();
        resp.put("msg", codeAndMsg.getCode());
        resp.put("code", codeAndMsg.getMsg());
        resp.put("data", data);
        return resp;
    }


}
