package com.databaseapi.demo.ApiModels;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class RegistrationUserInfo {
    private String name;
    private String password;
    private String email;

    public RegistrationUserInfo() {
    }
}
