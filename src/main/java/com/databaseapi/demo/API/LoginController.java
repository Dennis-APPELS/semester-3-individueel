package com.databaseapi.demo.API;

import com.databaseapi.demo.API.ApiModels.LoginUserInfo;
import com.databaseapi.demo.Logic.Model.UserContainer;
import com.databaseapi.demo.Logic.Services.VerificationService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@CrossOrigin(allowCredentials = "true", origins = "http://localhost:3000")
@RestController
@RequestMapping("Login")
public class LoginController {

    private final VerificationService verificationService;
    private UserContainer container;

    public LoginController(VerificationService verificationService, UserContainer container) {
        this.container = container;
        this.verificationService = verificationService;
    }


    @PostMapping(value= "/POST/Users/LoginInfo", consumes = "application/json")
    public String userLogin(@RequestBody LoginUserInfo userInfo, HttpServletRequest request,
                             HttpServletResponse response){
            if(verificationService.verifyUser(userInfo)){
                try{
                    request.getSession().setAttribute("UserId", container.GetUserByName(userInfo.getName()).getId());
                    return "Logged in successfully";
                }
                catch(Exception ex){
                    return ex.getMessage();
                }
                }
            else{
                return "Login failed";
            }
    }

}
