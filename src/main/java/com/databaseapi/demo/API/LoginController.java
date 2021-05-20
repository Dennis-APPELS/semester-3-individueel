package com.databaseapi.demo.API;

import com.databaseapi.demo.API.ApiModels.LoginUserInfo;
import com.databaseapi.demo.logic.Services.VerificationService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("Login")
public class LoginController {

    private final VerificationService verificationService;

    public LoginController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }


    @PostMapping(value= "/POST/Users/LoginInfo", consumes = "application/json")
    public boolean userLogin(@RequestBody LoginUserInfo userInfo){
        return verificationService.verifyUser(userInfo);
    }
}
