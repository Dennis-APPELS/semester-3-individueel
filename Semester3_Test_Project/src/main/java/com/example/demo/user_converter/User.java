package com.example.demo.user_converter;

import org.apache.logging.log4j.message.LoggerNameAwareMessage;

public class User {
    private String name;
    private int id;
    private boolean Mod;
    private boolean lobbyAdmin;

    public User(String name, int id, boolean mod, boolean lobbyAdmin) {
        this.name = name;
        this.id = id;
        Mod = mod;
        this.lobbyAdmin = lobbyAdmin;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isMod() {
        return Mod;
    }

    public boolean isLobbyAdmin() {
        return lobbyAdmin;
    }

    public void setMod(boolean mod) {
        Mod = mod;
    }

    public void setLobbyAdmin(boolean lobbyAdmin) {
        this.lobbyAdmin = lobbyAdmin;
    }
}
