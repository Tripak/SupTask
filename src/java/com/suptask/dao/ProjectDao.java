/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suptask.dao;

import com.suptask.entity.ProjectEntity;
import java.util.List;

/**
 *
 * @author Habib
 */
public interface ProjectDao {
    
    ProjectEntity       addProject(ProjectEntity project);
    
    List<ProjectEntity> getAllProjects();
    
    ProjectEntity       getProjectById(Long id);
    
    List<ProjectEntity> getProjectsByUser(Long id);
    
    ProjectEntity       update(ProjectEntity project);
    
    Boolean             remove(ProjectEntity project);
}
