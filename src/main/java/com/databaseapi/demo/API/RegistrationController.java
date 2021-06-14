package com.databaseapi.demo.API;
import com.databaseapi.demo.API.ApiModels.RegistrationUserInfo;
import com.databaseapi.demo.Logic.Services.RegistrationService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("Register")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(value = "/POST/Users/RegistrationInfo", consumes = "application/json")
    public String Register(@RequestBody RegistrationUserInfo userInfo){
            if(registrationService.registerUser(userInfo)){
                return "Registered successfully";
            }
            else{
                return "Failed to register";
            }
    }

}
