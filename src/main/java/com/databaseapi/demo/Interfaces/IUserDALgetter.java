package com.databaseapi.demo.Interfaces;

import com.databaseapi.demo.DTO.UserDTO;

import java.util.List;

public interface IUserDALgetter {
   List<UserDTO> GetAllUsers();
   UserDTO GetUserById(long userId);
   UserDTO GetUserByName(String username);

}
