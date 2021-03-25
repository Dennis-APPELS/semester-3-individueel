package com.databaseapi.demo.API;

import com.databaseapi.demo.ApiModels.UserInfo;
import com.databaseapi.demo.Converters.UserConverter;
import com.databaseapi.demo.Model.UserContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("GET")
public class GetHandler {

    @Autowired
    private UserContainer userContainer;

    private UserConverter converter = new UserConverter();

    public GetHandler(UserContainer container){
        userContainer = container;
    }

    @GetMapping("/Users/{id}")
    public UserInfo getUser(@PathVariable long id){
        return converter.convertUserToUserInfo(userContainer.GetUser(id));
    }
}
