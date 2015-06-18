/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suptask.dao.jpa;

import com.suptask.dao.UserDao;
import com.suptask.entity.ProjectEntity;
import com.suptask.entity.TaskEntity;
import com.suptask.entity.UserEntity;
import com.suptask.service.ProjectService;
import com.suptask.service.TaskService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


@Stateless
public class JpaUserDao implements UserDao {

    @EJB
    private ProjectService ps;
    
    @EJB
    private TaskService ts;
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public UserEntity addUser(UserEntity user) {
        em.persist(user);
        return user;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = cb.createQuery(UserEntity.class);
        return em.createQuery(query).getResultList();
    }

    @Override
    public UserEntity getUserById(Long id) {
        return em.find(UserEntity.class, id);
    }

    @Override
    public UserEntity getUserByLogin(String login) {
        CriteriaBuilder             cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity>   query = cb.createQuery(UserEntity.class);
        Root<UserEntity>            user = query.from(UserEntity.class);
        
        query.where(cb.equal(user.get("login"), login));
        
        List<UserEntity>            result = em.createQuery(query).getResultList();
        
        if (!result.isEmpty())
            return result.get(0);
        else
            return null;
    }

    @Override
    public Boolean remove(UserEntity user) {
       
        /*List<ProjectEntity> pjts = ps.getProjectsByUser(user.getId());
        for (ProjectEntity pjt : pjts){
            List<TaskEntity> tasks = ts.getTaskByProject(pjt.getId());
            for (TaskEntity task : tasks) {
                em.merge(task);
                em.remove(task);
            }*/
        System.out.println("User delete"+ user.getFirstName());
        user = em.merge(user);
        em.remove(user);
     
     return true;
    }

    @Override
    public UserEntity update(UserEntity user) {
        em.merge(user);
        return user;
    }
    
}
