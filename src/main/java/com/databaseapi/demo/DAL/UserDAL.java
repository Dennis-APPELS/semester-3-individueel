package com.databaseapi.demo.DAL;

import com.databaseapi.demo.DAL.DataModels.FriendshipDataModel;
import com.databaseapi.demo.DAL.DataModels.UserDataModel;
import com.databaseapi.demo.DTO.UserDTO;
import com.databaseapi.demo.Interfaces.IUserAuthentication;
import com.databaseapi.demo.Interfaces.IUserDALgetter;
import com.databaseapi.demo.Interfaces.IUserDALsetter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAL implements IUserDALgetter, IUserDALsetter, IUserAuthentication {
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("UserDB");
    EntityTransaction transaction;
    EntityManager manager  = factory.createEntityManager();

    public UserDAL() {
    }

    public void SaveUser(UserDTO userDTO){
        manager  = factory.createEntityManager();
        transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(new UserDataModel(userDTO));
        try{
            transaction.commit();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            System.out.println(ex.getStackTrace());
            transaction.rollback();
        }
        finally{
            if(manager.isOpen()){
                manager.close();
            }
            transaction = null;
        }

    }

    public String GetUserPassword(String username) {
        manager  = factory.createEntityManager();
        Query query = manager.createNativeQuery("Select password From Semester3Local.Project_Login.user_data_model" +
                " Where user_data_model.name = :username ");
        query.setParameter("username", username);
        try{
            return query.getSingleResult().toString();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            System.out.println(ex.getStackTrace());
            return ex.getMessage();
        }
    }

    public void DeleteUser(long userID){
        manager  = factory.createEntityManager();
        Query query = manager.createNativeQuery("Delete From Semester3Local.Project_Login.user_data_model " +
                " Where user_data_model.id = :userID");
        query.setParameter("userID", userID);
        try{
            query.executeUpdate();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            System.out.println(ex.getStackTrace());
        }
        finally{
            if(manager.isOpen()){
                manager.close();
            }
        }
    }

    public void UpdateUser(UserDTO userDTO){
        manager  = factory.createEntityManager();
        transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(new UserDataModel(userDTO));

        try{
            transaction.commit();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            System.out.println(ex.getStackTrace());
            transaction.rollback();
        }
        finally{
            if(manager.isOpen()){
                manager.close();
            }
            transaction = null;
        }
    }

    public List<UserDTO> GetAllUsers(){
        List<UserDTO> users = new ArrayList<>();
        manager  = factory.createEntityManager();
        Query query = manager.createNativeQuery("Select * From Semester3Local.Project_Login.user_data_model", UserDataModel.class);
        try{
            List<UserDataModel> result = query.getResultList();

            for (UserDataModel dataModel:
                    result) {
                users.add(new UserDTO(dataModel));
            }
            return users;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return users;
        }
        finally{
            if(manager.isOpen()){
                manager.close();
            }
        }

    }

    public UserDTO GetUserById(long userID){
        manager  = factory.createEntityManager();
        Query query = manager.createNativeQuery("Select * From Semester3Local.Project_Login.user_data_model" +
                " Where user_data_model.id = :userID", UserDataModel.class);
        query.setParameter("userID", userID);
        try{
            UserDataModel result = (UserDataModel) query.getSingleResult();
            return new UserDTO(result);
        }

        catch(Exception ex){
            System.out.println(ex.getMessage());
            return new UserDTO();
        }
        finally{
            if(manager.isOpen()){
                manager.close();
            }
        }
    }

    public UserDTO GetUserByName(String username){
        manager  = factory.createEntityManager();
        Query query = manager.createNativeQuery("Select * From UserDataModel" +
                " Where user_data_model.name = :username", UserDataModel.class);
        query.setParameter("username", username);
        try{
            UserDataModel result = (UserDataModel) query.getSingleResult();
            return new UserDTO(result);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return new UserDTO();
        }
        finally{
            if(manager.isOpen()){
                manager.close();
            }
        }
    }

    public List<UserDTO> GetFriendsByUserId(Long userId){
        manager  = factory.createEntityManager();
        List<UserDTO> result = new ArrayList<>();
        Query query = manager.createNativeQuery("Select * From FriendshipDataModel" +
                " Where user = :userId And isAccepted = true");
        query.setParameter("userId", userId);
        try{
            List<FriendshipDataModel> output = query.getResultList();

            for (FriendshipDataModel friendship:
                    output) {
                result.add(new UserDTO(friendship.getFriend()));
            }
            return result;
        }

        catch(Exception ex){
            System.out.println(ex.getMessage());
            return result;
        }
        finally{
            if(manager.isOpen()){
                manager.close();
            }
        }
    }

}
