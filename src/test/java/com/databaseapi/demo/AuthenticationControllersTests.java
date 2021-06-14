package com.databaseapi.demo;

import com.databaseapi.demo.API.ApiModels.LoginUserInfo;
import com.databaseapi.demo.API.ApiModels.RegistrationUserInfo;
import com.databaseapi.demo.API.LoginController;
import com.databaseapi.demo.Interfaces.IUserAuthentication;
import com.databaseapi.demo.Interfaces.IUserDALgetter;
import com.databaseapi.demo.Interfaces.IUserDALsetter;
import com.databaseapi.demo.Logic.Model.User;
import com.databaseapi.demo.Logic.Model.UserContainer;
import com.databaseapi.demo.Logic.Services.RegistrationService;
import com.databaseapi.demo.Logic.Services.VerificationService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.mock.web.MockBodyContent;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class AuthenticationControllersTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private VerificationService logservice;

    @MockBean
    private RegistrationService regservice;

    @MockBean
    private IUserAuthentication userAuthentication;

    @MockBean
    private IUserDALsetter userDALsetter;

    @MockBean
    private IUserDALgetter userDALgetter;

    @MockBean
    private UserContainer container;

    @Before
    public void RegisterTestPatient(){
    }

    @Test
    public void TestIfLogInAPIRecievesCorrectly(){
        LoginUserInfo info = new LoginUserInfo();
        info.setName("test");
        info.setPassword("testaroo");
        String result = "Logged in successfully";
        byte[] infoJson = ConvertLoginToJson(info);
        try{
            logservice = new VerificationService(userAuthentication);
            given(logservice.verifyUser(info)).willReturn(true);
            mvc.perform(post("http://localhost:8080/Login/POST/Users/LoginInfo")
                    .content((infoJson))
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().string(contains(result)));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void TestIfAPILogInRespondsCorrectlyWithWrongPassword(){
        LoginUserInfo info = new LoginUserInfo();
        info.setName("test");
        info.setPassword("testa");
        String result = "Log in failed";
        byte[] infoJson = ConvertLoginToJson(info);
        try{
            logservice = new VerificationService(userAuthentication);
            given(logservice.verifyUser(info)).willReturn(true);
            mvc.perform(post("http://localhost:8080/Login/POST/Users/LoginInfo")
                    .content((infoJson))
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().string(contains(result)));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void TestIfLogInAPIRespondsCorrectlyWithWrongUsername(){
        LoginUserInfo info = new LoginUserInfo();
        info.setName("te");
        info.setPassword("testaroo");
        String result = "Log in failed";
        byte[] infoJson = ConvertLoginToJson(info);
        try{
            logservice = new VerificationService(userAuthentication);
            given(logservice.verifyUser(info)).willReturn(true);
            mvc.perform(post("http://localhost:8080/Login/POST/Users/LoginInfo")
                    .content((infoJson))
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().string(contains(result)));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void TestIfRegisterAPISavesUserCorrectly(){
        RegistrationUserInfo info = new RegistrationUserInfo();
        info.setName("te");
        info.setPassword("testaroo");
        info.setEmail("test@test.test");
        String result = "Registered successfully";
        byte[] infoJson = ConvertRegisterToJson(info);
        try{
            container = new UserContainer(userDALgetter, userDALsetter);
            regservice = new RegistrationService(container);
            given(regservice.registerUser(info));
            mvc.perform(post("http://localhost:8080/Login/POST/Users/LoginInfo")
                    .content((infoJson))
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().string(contains(result)));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void TestIfRegistrationFailsWhenUserAlreadyExists(){
        RegistrationUserInfo info = new RegistrationUserInfo();
        info.setName("test");
        info.setPassword("testaroo");
        info.setEmail("test@test.test");
        String result = "Failed to register";
        byte[] infoJson = ConvertRegisterToJson(info);
        try{
            container = new UserContainer(userDALgetter, userDALsetter);
            regservice = new RegistrationService(container);
            given(regservice.registerUser(info));
            mvc.perform(post("http://localhost:8080/Login/POST/Users/LoginInfo")
                    .content((infoJson))
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().string(contains(result)));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void TestIfRegistrationFailsWhenDataIsIncomplete(){
        RegistrationUserInfo info = new RegistrationUserInfo();
        info.setName("te");
        info.setPassword("testaroo");
        info.setEmail("test@test.test");
        String result = "Failed to register";
        byte[] infoJson = ConvertRegisterToJson(info);
        try{
            container = new UserContainer(userDALgetter, userDALsetter);
            regservice = new RegistrationService(container);
            given(regservice.registerUser(info));
            mvc.perform(post("http://localhost:8080/Login/POST/Users/LoginInfo")
                    .content((infoJson))
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().string(contains(result)));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }


    private byte[] ConvertLoginToJson(LoginUserInfo info){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return mapper.writeValueAsBytes(info);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return ex.getMessage().getBytes();
        }
    }

    private byte[] ConvertRegisterToJson(RegistrationUserInfo info){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return mapper.writeValueAsBytes(info);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return ex.getMessage().getBytes();
        }
    }
}
