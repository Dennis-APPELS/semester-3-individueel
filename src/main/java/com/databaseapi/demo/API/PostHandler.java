package com.databaseapi.demo.API;

import com.databaseapi.demo.Logic.Model.UserContainer;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("POST")
public class PostHandler {

    private UserContainer userContainer = new UserContainer();

}
