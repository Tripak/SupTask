/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suptask.service;

import com.suptask.dao.UserDao;
import com.suptask.entity.UserEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Habib
 */
@Stateless
public class UserService {
    
    @EJB
    private UserDao userDao;
    
    public UserEntity addUser(UserEntity user){
        return userDao.addUser(user);
    }
    
    public List<UserEntity> getAllUsers() {
        return userDao.getAllUsers();
    }
    
    public UserEntity getUserById(Long id) {
        return userDao.getUserById(id);
    }
    
    public UserEntity getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }
    
    public Boolean remove(UserEntity user) {
        return userDao.remove(user);
    }
    
    public UserEntity update(UserEntity user) {
        return userDao.update(user);
    }
}
