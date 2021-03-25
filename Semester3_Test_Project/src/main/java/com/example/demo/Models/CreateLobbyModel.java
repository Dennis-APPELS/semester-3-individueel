package com.example.demo.Models;

import com.example.demo.user_converter.User;

public class CreateLobbyModel {
    private User user;
    private String name;

    public CreateLobbyModel(User user, String name) {
        this.user = user;
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
