package com.WebSocket.JavaWebDemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 用来封装消息的工具类
 * @create: 2021-05-30 18:43
 **/
public class WS_MessageUtils {
    public static String getMessage(boolean isSystemMessage, String fromName, Object message) {
        try {
            WS_ResultMessage result = new WS_ResultMessage();
            result.setSystem(isSystemMessage);
            result.setMessage(message);
            if (fromName != null) {
                result.setFromName(fromName);
            }
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
