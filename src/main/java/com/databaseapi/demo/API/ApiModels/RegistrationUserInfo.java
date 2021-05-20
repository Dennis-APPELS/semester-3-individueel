package com.databaseapi.demo.API.ApiModels;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegistrationUserInfo {
    private String name;
    private String password;
    private String email;

    public RegistrationUserInfo() {
    }
}
