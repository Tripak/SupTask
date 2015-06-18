/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suptask.bean;

import com.suptask.entity.UserEntity;
import com.suptask.service.UserService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Habib
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private UserService us;
    
    private RedirectBean redirectBean = new RedirectBean();


    private String      login = null;
    private String      password = null;
    private UserEntity  user = new UserEntity();
   
    public String loginIn(){
        UserEntity cuser = us.getUserByLogin(login);
        
        if (cuser != null && cuser.getPassword().equals(password)) {
            user = cuser;
            login = null;
        }
        
        password = null;
        return redirectBean.redirectionIndex("index");
    }
    
    public String logOut() {
        user = new UserEntity();
        login = null;
        password = null;
        return redirectBean.redirectionIndex("index");
    }
    
    public String register() {
        
       if( us.getUserByLogin(user.getLogin()) == null )
       {
          user = us.addUser(user);
          return redirectBean.redirection("account");
       }
       else
       {
          return redirectBean.redirection("register");
       }
    }
    
    public RedirectBean getRedirectBean() {
        return redirectBean;
    }

    public void setRedirectBean(RedirectBean redirectBean) {
        this.redirectBean = redirectBean;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
    
}
