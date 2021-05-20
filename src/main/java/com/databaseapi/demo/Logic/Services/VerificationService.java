package com.databaseapi.demo.Logic.Services;

import com.databaseapi.demo.API.ApiModels.LoginUserInfo;
import com.databaseapi.demo.Logic.Model.User;
import com.databaseapi.demo.Logic.Model.UserContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerificationService {
    @Autowired
    private UserContainer userContainer;

    public boolean verifyUser(LoginUserInfo loginInfo){
            User user = userContainer.GetUser(loginInfo.getName());
            if(user.getPassword().matches(loginInfo.getPassword())){
                return true;
            }
            else return false;
    }
}
