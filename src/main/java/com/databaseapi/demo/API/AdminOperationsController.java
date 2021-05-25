package com.databaseapi.demo.API;

import com.databaseapi.demo.API.ApiModels.UserInfo;
import com.databaseapi.demo.DAL.Converters.UserConverter;
import com.databaseapi.demo.Logic.Model.User;
import com.databaseapi.demo.Logic.Model.UserContainer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("AdminOperations")
public class AdminOperationsController {
    private UserContainer container;
    private UserConverter converter;
    public AdminOperationsController(UserContainer container) {
        this.container = container;
    }

    @GetMapping("/GET/Users")
    public List<UserInfo> getUsers(){
        List<UserInfo> result = new ArrayList<>();
        List<User> users = container.GetUsers();
        for (User user:
             users) {
            result.add(converter.convertUserToUserInfo(user));
        }
        return result;
    }
}
