/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suptask.service;

import com.suptask.dao.ProjectDao;
import com.suptask.entity.ProjectEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Habib
 */
@Stateless
public class ProjectService {
    
    @EJB
    private ProjectDao projectDao;
    
    public void addProject(ProjectEntity project) {
        projectDao.addProject(project);
    }
    
    public List<ProjectEntity> getAllProjects() {
        return projectDao.getAllProjects();
    }
    
    public ProjectEntity getProjectById(Long id) {
        return projectDao.getProjectById(id);
    }
    
    public List<ProjectEntity> getProjectsByUser(Long id) {
        return projectDao.getProjectsByUser(id);
    }
    
    public ProjectEntity update(ProjectEntity project) {
        return projectDao.update(project);
    }
    
    public Boolean remove(ProjectEntity project) {
        return projectDao.remove(project);
    }
}
