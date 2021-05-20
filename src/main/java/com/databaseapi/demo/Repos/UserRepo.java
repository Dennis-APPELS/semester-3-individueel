package com.databaseapi.demo.Repos;

import com.databaseapi.demo.DataModels.UserDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepo extends JpaRepository<UserDataModel, Long> {
}
