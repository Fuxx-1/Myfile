package ltd.newimg.booksystem.Util;

import com.alibaba.fastjson.JSONObject;
import ltd.newimg.booksystem.Util.en.ReturnCodeEnum;

public class ReturnUtil {

    public static String returnMsg(ReturnCodeEnum codeAndMsg, Object data) {
        JSONObject resp = new JSONObject();
        resp.put("msg", codeAndMsg.getMsg());
        resp.put("code", codeAndMsg.getCode());
        resp.put("data", data);
        return resp.toJSONString();
    }

    public static JSONObject returnObj(ReturnCodeEnum codeAndMsg, Object data) {
        JSONObject resp = new JSONObject();
        resp.put("msg", codeAndMsg.getMsg());
        resp.put("code", codeAndMsg.getCode());
        resp.put("data", data);
        return resp;
    }


}
