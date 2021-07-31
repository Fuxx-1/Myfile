package com.demo.service; /**
 * @Class: WebSocketMessageService
 * @Description: 使用webscoket连接向用户发送信息
 * @author JFPZ
 * @date 2017年5月15日 上午20:17:01
 */

import com.demo.websocket.Websocket;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("webSocketMessageService")
public class WSService {
    private Logger logger = LoggerFactory.getLogger(WSService.class);
    //声明websocket连接类
    private Websocket websocketDemo = new Websocket();

    /**
     * @Title: sendToAllTerminal
     * @Description: 调用websocket类给用户下的所有终端发送消息
     * @param @param userId 用户id
     * @param @param message 消息
     * @param @return 发送成功返回true，否则返回false
     */
    public Boolean sendToAllTerminal(Long userId, String message) {
        logger.debug("向用户{}的消息：{}", userId, message);
        System.out.println("向用户" + userId + "的消息：" + message);
        if (websocketDemo.sendMessageToUser(userId, message)) {
            return true;
        } else {
            return false;
        }
    }
}
