package com.databaseapi.demo.Interfaces;

import com.databaseapi.demo.DTO.UserDTO;

public interface IUserDALsetter {
    void UpdateUser(UserDTO user);
    void SaveUser(UserDTO user);
    void DeleteUser(long userID);
}
