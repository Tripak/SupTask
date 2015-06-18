/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suptask.service;

import com.suptask.dao.TaskDao;
import com.suptask.entity.TaskEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Habib
 */
@Stateless
public class TaskService {
    
    @EJB
    private TaskDao taskDao;
    
    public void addTask(TaskEntity task) {
        taskDao.addTask(task);
    }
    
    public TaskEntity getTaskById(Long id) {
        return taskDao.getTaskById(id);
    }
    
    public List<TaskEntity> getTaskByProject(Long id) {
        return taskDao.getTaskByProject(id);
    }
    
    public List<TaskEntity> getTaskByUser(Long id) {
        return taskDao.getTaskByUser(id);
    }
    
    public TaskEntity update(TaskEntity task) {
        return taskDao.update(task);
    }
    
    public Boolean remove(TaskEntity task) {
        return taskDao.remove(task);
    }
}
