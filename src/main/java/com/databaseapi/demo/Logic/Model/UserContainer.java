package com.databaseapi.demo.Logic.Model;

import com.databaseapi.demo.DTO.UserDTO;
import com.databaseapi.demo.Interfaces.IUserDALgetter;
import com.databaseapi.demo.Interfaces.IUserDALsetter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserContainer {
    private List<User> users = new ArrayList<>();
    private IUserDALgetter dal;
    private IUserDALsetter setter;

    public UserContainer(IUserDALgetter dal, IUserDALsetter setter) {
        this.dal = dal;
        this.setter = setter;
        List<UserDTO> result = dal.GetAllUsers();
        for (UserDTO dto:
                result) {
            users.add(new User(dto));
        }
    }

    public User GetUserById(Long id) throws Exception{
        for (User user:
             users) {
            if(user.getId().equals(id)){
                return user;
            }
        }
        throw new Exception("User niet gevonden");
    }

    public User GetUserByName(String name)throws Exception{
        for (User user:
                users) {
            if(user.getName().equals(name)){
                return user;
            }
        }
        throw new Exception("User niet gevonden");
    }

    public List<User> GetUsers(){
        return users;
    }

    private void Refresh(){
        List<UserDTO> result = dal.GetAllUsers();
        for (UserDTO dto:
                result) {
            users.add(new User(dto));
        }
    }

    public void SaveUser(User user) throws Exception{
        for (User addedUser:
             users) {
            if(addedUser.getName().equals(user.getName()) || addedUser.getPassword().equals(user.getPassword())){
                throw new Exception("User bestaat al");
            }
        }
        users.add(user);
        user.Save(setter);
    }

    public void UpdateUser(User user){
        for (User userToUpdate:
             users) {
            if(userToUpdate.getId().equals(user.getId())){
                userToUpdate.Update(user, setter);
            }
        }

    }

    public List<User> GetFriends(String username){
        try{
            User user = GetUserByName(username);
            List<UserDTO> friendsDTO = dal.GetFriendsByUserId(user.getId());
            List<User> users = new ArrayList<>();
            for (UserDTO dto:
                 friendsDTO) {
                users.add(new User(dto));
            }
            return users;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return new ArrayList<User>();
    }

}
