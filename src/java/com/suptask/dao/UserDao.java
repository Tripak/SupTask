/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suptask.dao;

import com.suptask.entity.UserEntity;
import java.util.List;

/**
 *
 * @author Habib
 */
public interface UserDao {
    
    UserEntity          addUser(UserEntity user);
    
    List<UserEntity>    getAllUsers();
    
    UserEntity          getUserById(Long id);
    
    UserEntity          getUserByLogin(String login);
    
    Boolean             remove(UserEntity user);
    
    UserEntity          update(UserEntity user);
}
