package com.WebSocket.JavaWebDemo;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @create: 2021-05-30 17:53
 **/
@ServerEndpoint("/WebSocket")
public class WebSocketServlet {
    //Upgrade WebSocket
    //Status Code: 101
    //握手
//    private static Set<chat> WebSocketSet = new HashSet<chat>();

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {

    }

    @OnOpen
    public void onOpen(Session session) {

    }
}
