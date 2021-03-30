package com.databaseapi.demo.Model;

import com.databaseapi.demo.ApiModels.LoginUserInfo;
import com.databaseapi.demo.ApiModels.RegistrationUserInfo;
import com.databaseapi.demo.ApiModels.UserInfo;
import com.databaseapi.demo.DataModels.UserDataModel;
import com.databaseapi.demo.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserContainer {
    private List<User> users = new ArrayList<>();

    @Autowired
    private UserRepo userRepo;



    public User GetUser(Long id){
        return new User(userRepo.getOne(id));
    }

    public User GetUser(String name){
        UserDataModel user = new UserDataModel();
        user.setName(name);
        Example<UserDataModel> example = Example.of(user);
        List<UserDataModel> output = userRepo.findAll(example);
        return new User(output.get((int)output.stream().count() - 1));
    }

    public boolean userExists(User user){
        UserDataModel userDataModel = new UserDataModel(user);
        Example<UserDataModel> example = Example.of(userDataModel);
        if(userRepo.exists(example)) return true;
        else return false;
    }

    public void saveUser(User user){
        UserDataModel userDataModel = new UserDataModel(user);
        Example<UserDataModel> example = Example.of(userDataModel);
        if(!userRepo.exists(example)) userRepo.save(userDataModel);
    }

}
