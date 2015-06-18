/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suptask.dao.jpa;

import com.suptask.dao.TaskDao;
import com.suptask.entity.TaskEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Habib
 */
@Stateless
public class JpaTaskDao implements TaskDao {

    @EJB
    private EntityManager em;
    
    @Override
    public TaskEntity addTask(TaskEntity task) {
        em.persist(task);
        return task;
    }

    @Override
    public TaskEntity getTaskById(Long idTask) {
        return em.find(TaskEntity.class, idTask);
    }

    @Override
    public List<TaskEntity> getTaskByProject(Long FK_idProject) {
        CriteriaBuilder                 cb = em.getCriteriaBuilder();
        CriteriaQuery<TaskEntity>       query = cb.createQuery(TaskEntity.class);
        Root<TaskEntity>                project = query.from(TaskEntity.class);
        
        query.where(cb.equal(project.get("FK_idProject"), FK_idProject));
        
        List<TaskEntity>             result = em.createQuery(query).getResultList();
        
        if (!result.isEmpty())
            return result;
        else
            return null;
    }

    @Override
    public List<TaskEntity> getTaskByUser(Long FK_idUser) {
        CriteriaBuilder                 cb = em.getCriteriaBuilder();
        CriteriaQuery<TaskEntity>       query = cb.createQuery(TaskEntity.class);
        Root<TaskEntity>                project = query.from(TaskEntity.class);
        
        query.where(cb.equal(project.get("FK_idUser"), FK_idUser));
        
        List<TaskEntity>                result = em.createQuery(query).getResultList();
        
        if (!result.isEmpty())
            return result;
        else
            return null;
    }

    @Override
    public Boolean remove(TaskEntity task) {
        em.merge(task);
        em.remove(task);
        return true;
    }

    @Override
    public TaskEntity update(TaskEntity task) {
        em.merge(task);
        return task;
    }
    
}
