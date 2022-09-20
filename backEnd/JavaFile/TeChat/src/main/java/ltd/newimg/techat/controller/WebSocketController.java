package ltd.newimg.techat.controller;

import ltd.newimg.techat.conf.WebsocketConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Fuxx-1
 * @date 2021年09月23日 20:21
 */
@Component
@ServerEndpoint(value = "/chat", configurator = WebsocketConfiguration.class) //说明创建websocket的endpoint
@CrossOrigin
public class WebSocketController {
    HttpSession respSession;
    /**
     * 存储全部链接对象
     */
    private static ConcurrentHashMap<Integer, Session> clients = new ConcurrentHashMap<>();

    @OnOpen
    public void open(Session session, EndpointConfig config) {
        this.respSession = (HttpSession) config.getUserProperties().get("HttpSession");
        int id = (int) respSession.getAttribute("id");
        clients.put(id, session);
    }

    @OnClose
    public void close(@PathParam("id") int id, Session session) {
        clients.remove(id);
        try {
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConcurrentHashMap<Integer, Session> getClients() {
        return clients;
    }

    @OnError
    public void error(Throwable throwable) {
        throwable.printStackTrace();
    }

    @OnMessage
    public void Message(String message) {
        int id = (int) respSession.getAttribute("id");
//        MessageSendServiceImpl.sendMessage(clients, id, message);
    }


}

