package com.example.demo.lobby_controller;

import com.example.demo.Models.CreateLobbyModel;
import com.example.demo.Models.JoinModel;
import com.example.demo.user_converter.User;
import com.example.demo.user_converter.UserContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lobby")
public class Lobby_Controller {
    private LobbyContainer lobbies;

    @Autowired
    public Lobby_Controller (LobbyContainer container){ lobbies = container;}

    @PostMapping(value = "/join", consumes = "application/json", produces = "application/json")
    public String JoinLobby(@RequestBody JoinModel joinModel){
        return lobbies.SelectLobby(joinModel.getLobbyId()).AddUser(joinModel.getUser());
    }

    @PostMapping(value = "/Create", consumes = "application/json")
    public void CreateLobby(@RequestBody CreateLobbyModel createLobbyModel){
        createLobbyModel.getUser().setLobbyAdmin(true);
        UserContainer users = new UserContainer();
        users.AddUser(createLobbyModel.getUser());
        lobbies.CreateLobby(createLobbyModel.getName(), users);
    }

    @GetMapping("/test")
    public Lobby GetLobbies(){
        User user = new User("appels", 1, false, false);
        UserContainer users = new UserContainer();
        users.AddUser(user);
        return new Lobby("appels", 1, users);
    }
}
