package com.example.demo.Models;

import com.example.demo.user_converter.User;

public class JoinModel {
    private Integer lobbyId;
    private User user;

    public JoinModel(Integer lobbyId, User user) {
        this.lobbyId = lobbyId;
        this.user = user;
    }

    public Integer getLobbyId() {
        return lobbyId;
    }

    public void setLobbyId(Integer lobbyId) {
        this.lobbyId = lobbyId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
