package com.databaseapi.demo.DTO;

import com.databaseapi.demo.DAL.DataModels.UserDataModel;
import com.databaseapi.demo.Logic.Model.User;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class UserDTO {
    private Long id;
    private String password;
    private String name;
    private String email;
    private LocalDateTime lastOnline;
    private int timesReported;


    public UserDTO (UserDataModel user){
        id = user.getId();
        password = user.getPassword();
        name = user.getName();
        email = user.getEmail();
        lastOnline = user.getLastOnline();
        timesReported = user.getTimesReported();
    }

    public UserDTO (User user){
        if(user.getId() != null){
            id = user.getId();
        }
        password = user.getPassword();
        name = user.getName();
        email = user.getEmail();
        lastOnline = user.getLastOnline();
        timesReported = user.getTimesReported();
    }

    public UserDTO() {
    }
}
