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
    private UserRepo repo;

    public UserContainer(UserRepo repo) {
        this.repo = repo;
    }

    public User GetUser(Long id){
        return new User(repo.getOne(id));
    }

    public User GetUser(String name){
        UserDataModel user = new UserDataModel();
        user.setName(name);
        Example<UserDataModel> example = Example.of(user);
        List<UserDataModel> output = repo.findAll(example);
        return new User(output.get(0));
    }

    public boolean loginCheck(LoginUserInfo loginInfo){
        try{
            User user = GetUser(loginInfo.getName());
            if(user.getPassword() == loginInfo.getPassword()){
                return true;
            }
            else return false;
        }
        catch(Exception exception){
            return false;
        }
    }

    public void RegisterUser(RegistrationUserInfo userInfo) throws Exception {
        try{
            User user = new User(userInfo);
            UserDataModel userDataModel = new UserDataModel(user);
            Example<UserDataModel> example = Example.of(userDataModel);
            if(!repo.exists(example)) repo.save(userDataModel);
            else throw new Exception();
        }
        catch(Exception exception){
            throw new Exception();
        }
    }
}
