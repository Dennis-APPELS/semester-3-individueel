package com.databaseapi.demo.logic.Model;

import com.databaseapi.demo.API.ApiModels.RegistrationUserInfo;
import com.databaseapi.demo.DAL.DataModels.UserDataModel;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class User {
    private Long id;
    private String password;
    private String name;
    private String email;
    private LocalDateTime lastOnline;
    private int timesReported;

    public User (UserDataModel user){
        id = user.getId();
        password = user.getPassword();
        name = user.getName();
        email = user.getEmail();
        lastOnline = user.getLastOnline();
        timesReported = user.getTimesReported();
    }

    public User (RegistrationUserInfo user){
        password = user.getPassword();
        name = user.getName();
        email = user.getEmail();
    }

}
