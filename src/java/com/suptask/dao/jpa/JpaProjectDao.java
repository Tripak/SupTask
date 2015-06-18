/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suptask.dao.jpa;

import com.suptask.dao.ProjectDao;
import com.suptask.entity.ProjectEntity;
import com.suptask.entity.TaskEntity;
import com.suptask.service.TaskService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Habib
 */
@Stateless
public class JpaProjectDao implements ProjectDao {

    @EJB
    private TaskService ts;
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public ProjectEntity addProject(ProjectEntity project) {
        em.persist(project);
        return project;
    }

    @Override
    public List<ProjectEntity> getAllProjects() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProjectEntity> query = cb.createQuery(ProjectEntity.class);
        return em.createQuery(query).getResultList();
    }

    @Override
    public ProjectEntity getProjectById(Long id) {
        return em.find(ProjectEntity.class, id);
    }

    @Override
    public List<ProjectEntity> getProjectsByUser(Long id) {
        CriteriaBuilder                 cb = em.getCriteriaBuilder();
        CriteriaQuery<ProjectEntity>    query = cb.createQuery(ProjectEntity.class);
        Root<ProjectEntity>             project = query.from(ProjectEntity.class);
        
        query.where(cb.equal(project.get("FK_idUser"), id));
        
        List<ProjectEntity>             result = em.createQuery(query).getResultList();
        
        if (!result.isEmpty())
            return result;
        else
            return null;
    }

    @Override
    public ProjectEntity update(ProjectEntity project) {
        em.merge(project);
        return project;
    }

    @Override
    public Boolean remove(ProjectEntity project) {
        List<TaskEntity> tasks = ts.getTaskByProject(project.getId());
        for (TaskEntity task : tasks) {
            em.merge(task);
            em.remove(task);
        }
        em.merge(project);
        em.remove(project);
        return true;
    }
    
}
