package com.databaseapi.demo.DAL.Converters;

import com.databaseapi.demo.API.ApiModels.UserInfo;
import com.databaseapi.demo.Logic.Model.User;

public class UserConverter {

    public UserInfo convertUserToUserInfo(User user){
        UserInfo output = new UserInfo();
        output.setId(user.getId());
        output.setName(user.getName());
        output.setEmail(user.getEmail());
        output.setTimesReported(user.getTimesReported());
        return output;
    }


}
