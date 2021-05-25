package com.databaseapi.demo.DAL;

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
    }

    public void UpdateUser(UserDTO userDTO){
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
        Query query = manager.createNativeQuery("Select * From Semester3Local.Project_Login.user_data_model", UserDataModel.class);
        List<UserDataModel> result = query.getResultList();
        List<UserDTO> users = new ArrayList<>();
        for (UserDataModel dataModel:
             result) {
            users.add(new UserDTO(dataModel));
        }
        return users;
    }

    public UserDTO GetUserById(long userID){
        Query query = manager.createNativeQuery("Select * From Semester3Local.Project_Login.user_data_model" +
                " Where user_data_model.id = :userID", UserDataModel.class);
        query.setParameter("userID", userID);
        UserDataModel result = (UserDataModel) query.getSingleResult();
        return new UserDTO(result);

    }

    public UserDTO GetUserByName(String username){
        Query query = manager.createNativeQuery("Select * From Semester3Local.Project_Login.user_data_model" +
                " Where user_data_model.name = :username", UserDataModel.class);
        query.setParameter("username", username);
        UserDataModel result = (UserDataModel) query.getSingleResult();
        return new UserDTO(result);
    }


}
