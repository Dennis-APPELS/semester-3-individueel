package com.databaseapi.demo.API.ApiModels;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginUserInfo {
    private String name;
    private String password;

    public LoginUserInfo() {
    }
}
