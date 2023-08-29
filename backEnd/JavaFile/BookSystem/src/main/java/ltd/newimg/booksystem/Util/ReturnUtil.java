package ltd.newimg.booksystem.Util;

import com.alibaba.fastjson.JSONObject;

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
