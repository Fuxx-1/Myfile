package com.WebSocket.JavaWebDemo;

/**
 * 用于登录时相应给浏览器的数据
 * @create: 2021-05-30 18:41
 **/
public class WS_Result {
    private boolean flag;
    private String message;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
