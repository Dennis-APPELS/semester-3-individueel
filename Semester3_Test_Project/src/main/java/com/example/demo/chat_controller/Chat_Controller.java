package com.example.demo.chat_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
@CrossOrigin
@RestController
public class Chat_Controller {

    @MessageMapping("/ChatSend")
    @SendTo("/topic/public")
    public MessageModel sendMessage(@Payload MessageModel message){
        return message;
    }

    @MessageMapping("/ChatNewUser")
    @SendTo("/topic/public")
    public Greeting newUser(MessageModel message){
        return new Greeting("Hello " + message.getFrom());
    }

    @MessageMapping("/Hello")
    @SendTo("/topic/greetings")
    public Greeting greetUser(HelloMesssage message){
        return new Greeting("Hello " + HtmlUtils.htmlEscape(message.getName()));
    }


}
