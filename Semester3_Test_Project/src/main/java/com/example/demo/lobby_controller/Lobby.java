package com.example.demo.lobby_controller;

import com.example.demo.chat_controller.Chat_Controller;
import com.example.demo.user_converter.User;
import com.example.demo.user_converter.UserContainer;

import java.util.List;

public class Lobby {
    private String name;
    private int id;
    private UserContainer users;
    private Chat_Controller chatController = new Chat_Controller();

    public Lobby(String name, int id, UserContainer users) {
        this.name = name;
        this.id = id;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<User> getUsers() {
        return users.GetAllUsers();
    }



    public void RemoveUser(User userToRemove, User admin){

    }

    public String AddUser(User user){
        users.AddUser(user);
        return "Successfully Added!";
    }
}
