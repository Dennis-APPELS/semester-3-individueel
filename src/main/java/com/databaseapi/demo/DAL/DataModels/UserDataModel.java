package com.databaseapi.demo.DAL.DataModels;

import com.databaseapi.demo.logic.Model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity @Getter @Setter
public class UserDataModel {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String password;
    private String email;
    private LocalDateTime lastOnline;
    private int timesReported;

    public UserDataModel(User user){
        id = user.getId();
        name = user.getName();
        password = user.getPassword();
        email = user.getEmail();
        lastOnline = user.getLastOnline();
        timesReported = user.getTimesReported();
    }

    public UserDataModel(){}


}
