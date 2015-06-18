/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suptask.dao;

import com.suptask.entity.TaskEntity;
import java.util.List;

/**
 *
 * @author Habib
 */
public interface TaskDao {
    
    TaskEntity          addTask(TaskEntity task);
    
    TaskEntity          getTaskById(Long idTask);
    
    List<TaskEntity>    getTaskByProject(Long FK_idProject);
    
    List<TaskEntity>    getTaskByUser(Long FK_idUser);
    
    Boolean             remove(TaskEntity task);
    
    TaskEntity          update(TaskEntity task);
}
