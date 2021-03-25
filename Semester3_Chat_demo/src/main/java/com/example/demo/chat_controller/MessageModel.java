package com.example.demo.chat_controller;

import lombok.Builder;
import lombok.Getter;

@Builder
public class MessageModel {
    @Getter
    private String from;

    @Getter
    private String content;

    @Getter
    private MessageType type;
}
