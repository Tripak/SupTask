/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suptask.bean;

import com.suptask.entity.ProjectEntity;
import com.suptask.service.ProjectService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ProjectBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    ProjectService ps; 
    
    @ManagedProperty(value="#{loginBean.user.id}")
    private Long id;
    
    private String title;
    private final  List<ProjectEntity> list = ps.getProjectsByUser(id);

    public String newProject() {
        boolean exist = false;
        List<ProjectEntity> p = ps.getProjectsByUser(id);
        for (ProjectEntity i : p) {
            if (i.getTitle().equals(title))
                exist = true;
        }
        
        if (!exist) {
            ProjectEntity np = new ProjectEntity();
            np.setTitle(title);
            ps.addProject(np);
        }
        return "project";
    }

    public String getTitle() {
        return title;
    }
    
    public Long getId() {
        return id;
    }

    public List<ProjectEntity> getList() {
        return list;
    }
}
