package com.databaseapi.demo.logic.Services;

import com.databaseapi.demo.API.ApiModels.RegistrationUserInfo;
import com.databaseapi.demo.logic.Model.User;
import com.databaseapi.demo.logic.Model.UserContainer;
import org.springframework.stereotype.Component;

@Component
public class RegistrationService {

    private UserContainer userContainer;

    public RegistrationService(UserContainer userContainer){
        this.userContainer = userContainer;
    }

    public void registerUser(RegistrationUserInfo userInfo){
            User user = new User(userInfo);
            userContainer.saveUser(user);


    }
}
