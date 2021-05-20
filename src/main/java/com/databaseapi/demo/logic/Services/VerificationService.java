package com.databaseapi.demo.logic.Services;

import com.databaseapi.demo.API.ApiModels.LoginUserInfo;
import com.databaseapi.demo.logic.Model.User;
import com.databaseapi.demo.logic.Model.UserContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerificationService {

    private UserContainer userContainer;

    public VerificationService(UserContainer userContainer) {
        this.userContainer = userContainer;
    }

    public boolean verifyUser(LoginUserInfo loginInfo){
            User user = userContainer.GetUser(loginInfo.getName());
            if(user.getPassword().matches(loginInfo.getPassword())){
                return true;
            }
            else return false;
    }
}
