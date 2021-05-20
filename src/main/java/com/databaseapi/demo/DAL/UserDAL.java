package com.databaseapi.demo.DAL;

import com.databaseapi.demo.DAL.DataModels.UserDataModel;
import com.databaseapi.demo.DAL.Repos.UserRepo;
import com.databaseapi.demo.DTO.UserDTO;
import com.databaseapi.demo.logic.Model.User;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAL {

    private UserRepo repo;

    public UserDAL(UserRepo repo) {
        this.repo = repo;
    }

    public UserDTO GetUserByName(String username){
        UserDataModel user = new UserDataModel();
        user.setName(username);
        Example<UserDataModel> example = Example.of(user);
        List<UserDataModel> output = repo.findAll(example);
        return new UserDTO(output.get((int)output.stream().count() - 1));
    }
}
