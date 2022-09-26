package com.WebSocket.JavaWebDemo;

/**
 * 浏览器发送给服务器的websocket数据
 * @create: 2021-05-30 18:38
 **/
public class WS_Message {
    private String toName;
    private String message;

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
