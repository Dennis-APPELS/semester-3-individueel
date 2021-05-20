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

    @PostMapping("/POST/Users/RegistrationInfo")
    public boolean Register(@RequestBody RegistrationUserInfo userInfo){

            registrationService.registerUser(userInfo);
            return true;

    }
}
