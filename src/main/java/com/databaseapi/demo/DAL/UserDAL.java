package com.databaseapi.demo.DAL;

import com.databaseapi.demo.DAL.Repos.UserRepo;
import org.springframework.stereotype.Component;

@Component
public class UserDAL {
    private UserRepo repo;

    public UserDAL(UserRepo repo) {
        this.repo = repo;
    }
}
