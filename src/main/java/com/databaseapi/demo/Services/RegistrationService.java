package com.databaseapi.demo.Services;

import com.databaseapi.demo.ApiModels.RegistrationUserInfo;
import com.databaseapi.demo.Model.User;
import com.databaseapi.demo.Model.UserContainer;
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
