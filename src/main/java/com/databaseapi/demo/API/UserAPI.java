package com.databaseapi.demo.API;

import com.databaseapi.demo.API.ApiModels.UserInfo;
import com.databaseapi.demo.DAL.Converters.UserConverter;
import com.databaseapi.demo.Logic.Model.User;
import com.databaseapi.demo.Logic.Model.UserContainer;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("User")
public class UserAPI {

    private UserContainer users;
    private UserConverter converter;

    public UserAPI(UserContainer users) {
        this.users = users;
    }
    // Moet getest worden met mock data.
    @GetMapping(value = "/GET/Friends/{username}")
    public List<UserInfo> GetFriendsList(@PathVariable String username){
        List<UserInfo> result = new ArrayList<>();
        for (User user:
             users.GetFriends(username)) {
            result.add(converter.convertUserToUserInfo(user));
        }
        return result;
    }

    @GetMapping("/UserId")
    public Integer GetUserId(HttpServletRequest request){
        return (Integer) request.getSession().getAttribute("UserId");

    }
}