package com.databaseapi.demo.Converters;

import com.databaseapi.demo.ApiModels.UserInfo;
import com.databaseapi.demo.Model.User;

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
