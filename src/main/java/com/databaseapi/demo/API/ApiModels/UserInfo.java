package com.databaseapi.demo.API.ApiModels;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class UserInfo {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime lastOnline;
    private int timesReported;

    public UserInfo() {
    }
}
