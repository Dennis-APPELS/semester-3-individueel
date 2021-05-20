package com.databaseapi.demo.API;

import com.databaseapi.demo.ApiModels.LoginUserInfo;
import com.databaseapi.demo.ApiModels.RegistrationUserInfo;
import com.databaseapi.demo.Model.UserContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("POST")
public class PostHandler {

    private UserContainer userContainer = new UserContainer();

}
