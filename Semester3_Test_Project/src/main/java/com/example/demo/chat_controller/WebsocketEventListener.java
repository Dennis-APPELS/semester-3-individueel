package com.example.demo.chat_controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebsocketEventListener {

    private static Logger logger = LoggerFactory.getLogger(WebsocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations sendingOperations;

    /*@EventListener
    public void handleWebsocketConnectListener(SessionConnectedEvent event){
        logger.info("Yote");
        System.out.println("We got em!");
    }*/

    @EventListener
    public void handleWebsocketDisconnectListener(SessionDisconnectEvent event){
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        MessageModel message = MessageModel.builder().from(username).build();
        sendingOperations.convertAndSend("/topic/public", message);
    }
}
