package com.databaseapi.demo.Services;

import com.databaseapi.demo.ApiModels.LoginUserInfo;
import com.databaseapi.demo.Model.User;
import com.databaseapi.demo.Model.UserContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerificationService {
    @Autowired
    private UserContainer userContainer;

    public boolean verifyUser(LoginUserInfo loginInfo){
            User user = userContainer.GetUser(loginInfo.getName());
            if(user.getPassword() == loginInfo.getPassword()){
                return true;
            }
            else return false;
    }
}
