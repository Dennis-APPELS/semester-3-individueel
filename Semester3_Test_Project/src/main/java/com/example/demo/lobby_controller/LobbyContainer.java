package com.example.demo.lobby_controller;

import com.example.demo.user_converter.UserContainer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class LobbyContainer {
    List<Lobby> lobbyList = new ArrayList<>();

    public void CreateLobby(String name, UserContainer users){
        Lobby lobby = new Lobby(name, GetLastIndex() + 1, users);
        lobbyList.add(lobby);
    }

    public List<Lobby> GetLobbyList(){
        return lobbyList;
    }

    public void RemoveLobby(){

    }

    public Lobby SelectLobby(int id){
        return lobbyList.get(id);
    }

    private Integer GetLastIndex(){
        Lobby lastLobby = lobbyList.get(0);
        for (Lobby lobby:
             lobbyList) {
            if(lobby.getId() > lastLobby.getId()) lastLobby = lobby;
        }
        return lastLobby.getId();
    }
}
