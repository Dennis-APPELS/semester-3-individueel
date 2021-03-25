package com.databaseapi.demo.API;

import com.databaseapi.demo.ApiModels.LoginUserInfo;
import com.databaseapi.demo.ApiModels.RegistrationUserInfo;
import com.databaseapi.demo.Model.UserContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("POST")
public class PostHandler {

    @Autowired
    private UserContainer userContainer;

    public PostHandler(UserContainer container){
        userContainer = container;
    }

    @PostMapping(value= "/Users/Login", consumes = "application/json")
    public boolean userLogin(@RequestBody LoginUserInfo userInfo){
        return userContainer.loginCheck(userInfo);
    }

    @PostMapping(value = "/Users/Register", consumes = "application/json")
    public void userRegister(@RequestBody RegistrationUserInfo user){
        try{
            userContainer.RegisterUser(user);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User already exists", exc);
        }
    }
}
