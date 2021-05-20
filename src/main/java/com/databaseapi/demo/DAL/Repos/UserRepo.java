package com.databaseapi.demo.DAL.Repos;

import com.databaseapi.demo.DAL.DataModels.UserDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepo extends JpaRepository<UserDataModel, Long> {
}
