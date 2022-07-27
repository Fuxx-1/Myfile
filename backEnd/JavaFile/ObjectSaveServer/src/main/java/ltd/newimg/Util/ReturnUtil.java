package ltd.newimg.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author Fuxx-1@Github
 * @Description
 * @date 2022/07/21 13:56
 */
public class ReturnUtil {

    public static String returnMsg(String msg, int code, Object data) {
        JSONObject resp = new JSONObject();
        resp.put("msg", msg);
        resp.put("code", code);
        resp.put("data", data);
        return resp.toJSONString();
    }

    public static JSONObject returnObj(String msg, int code, Object data) {
        JSONObject resp = new JSONObject();
        resp.put("msg", msg);
        resp.put("code", code);
        resp.put("data", data);
        return resp;
    }
}
