package com.databaseapi.demo.DAL.DataModels;

import com.databaseapi.demo.DTO.UserDTO;
import com.databaseapi.demo.Logic.Model.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NamedNativeQuery;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = true)
    private GameDataModel lastPlayed;

    public UserDataModel(UserDTO user){
        id = user.getId();
        name = user.getName();
        password = user.getPassword();
        email = user.getEmail();
        lastOnline = user.getLastOnline();
        timesReported = user.getTimesReported();
    }

    public UserDataModel(){}


}
