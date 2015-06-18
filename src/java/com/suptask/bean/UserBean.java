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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Habib
 */
@ManagedBean
@ViewScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private UserService us;
    
    @ManagedProperty(value="#{loginBean.user.id}")
    private Long id;
    @ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean ;
    private UserEntity  user = new UserEntity();

    public UserBean(){
        
    }
    public String updateUser(UserEntity user){
        
         us.update(user);
         return "account";
    }
     public String deleteUser(UserEntity user){
         us.remove(user);
         loginBean.logOut();
         loginBean.setUser(null);
         String  path = FacesContext.getCurrentInstance().getViewRoot().getViewId();
         path = path.substring(0, path.indexOf("Facelet")) + "index.xhtml";
         return path;
    }

     public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
    
}
