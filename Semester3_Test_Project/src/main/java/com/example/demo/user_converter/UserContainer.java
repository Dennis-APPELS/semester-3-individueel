package com.example.demo.user_converter;

import com.example.demo.Exceptions.ItemNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class UserContainer {
    List<User> users = new ArrayList<>();


    public User GetUserByName(String name) throws ItemNotFoundException {
        for (User user:
             users) {
            if(user.getName() == name){
                return user;
            }
        }
        throw new ItemNotFoundException("User " + name + " was not found in the collection.");
    }

    public User GetUserById(Integer id) throws ItemNotFoundException {
        for (User user:
             users) {
            if(user.getId() == id){
                return user;
            }
        }
        throw new ItemNotFoundException("User id: " + id + " not found in this collection");
    }

    public List<User> GetAllUsers(){
        return users;
    }

    public void RemoveUserById( Integer id) throws ItemNotFoundException {
        for (User user:
             users) {
            if(user.getId() == id) {
                users.remove(user);
                break;
            }
            else throw new ItemNotFoundException("User id: " + id + " not found in this collection");
        }
    }

    public void RemoveUserByName( String name) throws ItemNotFoundException {
        for (User user:
             users) {
            if(user.getName() == name){
                users.remove(user);
                break;
            }
            else throw new ItemNotFoundException("User " + name + " not found in this collection");
        }
    }
    public User GetLobbyAdmin() throws ItemNotFoundException {
        for (User user:
             users) {
            if(user.isLobbyAdmin()) return user;
        }
        throw new ItemNotFoundException("How did you even manage to do this?! You knob!");
    }

    public List<User> GetMod(){
        List<User> output = new ArrayList<>();
        for (User user:
             users) {
            if(user.isMod()) output.add(user);
        }
        return output;
    }

    public void AssignMod(User _user){
        for (User user:
             users) {
            if(user == _user) user.setMod(true);
        }
    }

    public void RemoveMod(User _user){
        for (User user:
                users) {
            if(user == _user) user.setMod(false);
        }
    }

    public void AddUser(User user){
        users.add(user);
    }
}
