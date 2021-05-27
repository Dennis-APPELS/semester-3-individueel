package com.databaseapi.demo.Logic.Model;

import com.databaseapi.demo.API.ApiModels.RegistrationUserInfo;
import com.databaseapi.demo.DAL.DataModels.UserDataModel;
import com.databaseapi.demo.DTO.UserDTO;
import com.databaseapi.demo.Interfaces.IUserDALsetter;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class User {
    private Long id;
    private String password;
    private String name;
    private String email;
    private LocalDateTime lastOnline;
    private int timesReported;
    private List<Long> friendIds;



    public User (UserDTO user){
        id = user.getId();
        password = user.getPassword();
        name = user.getName();
        email = user.getEmail();
        lastOnline = user.getLastOnline();
        timesReported = user.getTimesReported();
        friendIds = user.getFriendIds();
    }

    public User (RegistrationUserInfo user){
        password = user.getPassword();
        name = user.getName();
        email = user.getEmail();
    }

    public void Update(User user, IUserDALsetter setter){
        id = user.getId();
        password = user.getPassword();
        name = user.getName();
        email = user.getEmail();
        lastOnline = user.getLastOnline();
        timesReported = user.getTimesReported();
        setter.UpdateUser(new UserDTO(this));
    }

    public void Save(IUserDALsetter setter){
        setter.SaveUser(new UserDTO(this));
    }

    public void Delete(IUserDALsetter setter){
        setter.DeleteUser(this.id);
    }

}
