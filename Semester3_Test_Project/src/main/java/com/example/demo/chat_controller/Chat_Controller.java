package com.example.demo.chat_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Chat_Controller {

    @MessageMapping("/Chat.send")
    @SendTo("/topic/public")
    public MessageModel sendMessage(@Payload MessageModel message){
        return message;
    }

    @MessageMapping("/Chat.newUser")
    @SendTo("/topic/public")
    public MessageModel newUser(@Payload MessageModel message, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", message.getFrom());
        return message;
    }


}
