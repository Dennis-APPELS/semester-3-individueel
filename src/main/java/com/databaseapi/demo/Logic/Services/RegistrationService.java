package com.databaseapi.demo.Logic.Services;

import com.databaseapi.demo.API.ApiModels.RegistrationUserInfo;
import com.databaseapi.demo.Logic.Model.User;
import com.databaseapi.demo.Logic.Model.UserContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationService {
    private UserContainer userContainer;

    public RegistrationService(UserContainer userContainer) {
        this.userContainer = userContainer;
    }

    public boolean registerUser(RegistrationUserInfo userInfo){
            User user = new User(userInfo);
            try{
                userContainer.SaveUser(user);
                return true;
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
                System.out.println(ex.getCause());
                System.out.println(ex.getStackTrace());
                return false;
            }


    }
}
