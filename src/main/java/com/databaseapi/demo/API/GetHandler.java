package com.databaseapi.demo.API;

import com.databaseapi.demo.API.ApiModels.UserInfo;
import com.databaseapi.demo.DAL.Converters.UserConverter;
import com.databaseapi.demo.Logic.Model.UserContainer;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("GET")
public class GetHandler {

    private UserContainer userContainer = new UserContainer();

    private UserConverter converter = new UserConverter();


    @GetMapping("/Users/{id}")
    public UserInfo getUser(@PathVariable long id){
        return converter.convertUserToUserInfo(userContainer.GetUser(id));
    }
}
