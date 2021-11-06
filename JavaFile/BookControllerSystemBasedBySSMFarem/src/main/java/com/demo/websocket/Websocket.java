package com.demo.websocket;
/**
 * @Class: WebsocketDemo
 * @Description: 给所用户所有终端推送消息
 * @author JFPZ
 * @date 2017年5月15日 上午21:38:08
 */

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

//websocket连接URL地址和可被调用配置
@ServerEndpoint(value = "/websocketDemo/{userId}")
public class Websocket {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //记录每个用户下多个终端的连接
    private static Map<Long, Set<Websocket>> userSocket = new HashMap<>();
    //日志记录
    //需要session来对用户发送数据, 获取连接特征userId
    private Session session;
    private Long userId;

    /**
     * @param @param  userId 用户id
     * @param @param  session websocket连接的session属性
     * @param @throws IOException
     * @Title: onOpen
     * @Description: websocekt连接建立时的操作
     */
    @OnOpen
    public void onOpen(@PathParam("userId") Long userId, Session session) {
        this.session = session;
        this.userId = userId;
        onlineCount++;
        System.out.println("用户登录：" + this.userId);
        //根据该用户当前是否已经在别的终端登录进行添加操作
        if (userSocket.containsKey(this.userId)) {
            userSocket.get(this.userId).add(this); //增加该用户set中的连接实例
        } else {
            Set<Websocket> addUserSet = new HashSet<>();
            addUserSet.add(this);
            userSocket.put(this.userId, addUserSet);
        }
    }

    /**
     * @Title: onClose
     * @Description: 连接关闭的操作
     */
    @OnClose
    public void onClose() {
        //移除当前用户终端登录的websocket信息,如果该用户的所有终端都下线了，则删除该用户的记录
        if (userSocket.get(this.userId).size() == 0) {
            userSocket.remove(this.userId);
        } else {
            userSocket.get(this.userId).remove(this);
        }
    }

    /**
     * @param @param message 收到的消息
     * @param @param session 该连接的session属性
     * @Title: onMessage
     * @Description: 收到消息后的操作
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("收到来自用户id为：" + this.userId + "的消息：" + message);
        Iterator<Long> it = userSocket.keySet().iterator();
        for (Map.Entry<Long, Set<Websocket>> entry : userSocket.entrySet()) {
            long id = entry.getKey();
            if (this.userId != id) {
                sendMessageToUser(id,  "{\"id\":" + this.userId +  ",\"message\":\"" + message + "\"}" );
            }
        }
    }

    /**
     * @param @param session 该连接的session
     * @param @param error 发生的错误
     * @Title: onError
     * @Description: 连接发生错误时候的操作
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * @param @param  userId 用户id
     * @param @param  message 发送的消息
     * @param @return 发送成功返回true，反则返回false
     * @Title: sendMessageToUser
     * @Description: 发送消息给用户下的所有终端
     */
    public Boolean sendMessageToUser(Long userId, String message) {
        if (userSocket.containsKey(userId)) {
            for (Websocket WS : userSocket.get(userId)) {
                try {
                    WS.session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}