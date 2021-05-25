package com.databaseapi.demo.Logic.Services;

import com.databaseapi.demo.API.ApiModels.LoginUserInfo;
import com.databaseapi.demo.Interfaces.IUserAuthentication;
import com.databaseapi.demo.Interfaces.IUserDALgetter;
import org.springframework.stereotype.Component;

@Component
public class VerificationService {
    private IUserAuthentication dal;

    public VerificationService(IUserAuthentication dal) {
        this.dal = dal;
    }

    public boolean verifyUser(LoginUserInfo loginInfo){
        String password = dal.GetUserPassword(loginInfo.getName());
        if(password.matches(loginInfo.getPassword())){
            return true;
        }
        else return false;
    }
}
