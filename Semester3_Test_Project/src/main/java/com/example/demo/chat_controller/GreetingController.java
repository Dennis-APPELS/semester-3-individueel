package com.example.demo.chat_controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


//@Controller
@RestController
@RequestMapping("Hello/Greetings")
public class GreetingController {

    //@SendTo("/topic/greetings")
    @PostMapping(value= "/Greet", consumes = "application/json", produces = "application/json")
    public Greeting greeting(@RequestBody String helloMessage){
        return new Greeting("Hello" + helloMessage + "!");
    }

}
