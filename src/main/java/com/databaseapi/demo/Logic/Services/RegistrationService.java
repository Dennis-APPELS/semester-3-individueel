package com.databaseapi.demo.Logic.Services;

import com.databaseapi.demo.API.ApiModels.RegistrationUserInfo;
import com.databaseapi.demo.Logic.Model.User;
import com.databaseapi.demo.Logic.Model.UserContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationService {
    @Autowired
    private UserContainer userContainer;

    public void registerUser(RegistrationUserInfo userInfo){
            User user = new User(userInfo);
            userContainer.saveUser(user);


    }
}
