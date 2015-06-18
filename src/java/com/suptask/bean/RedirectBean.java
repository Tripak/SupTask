/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suptask.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Habib
 */
@ManagedBean
@SessionScoped
public class RedirectBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public String redirection(String page)
    {
        String  path = FacesContext.getCurrentInstance().getViewRoot().getViewId();
        if((path.contains("Facelet")) == true)
        {
            System.out.println();
            return page;
        }
        else
        {
            return "Facelet/"+page+".xhtml";
        }
    }
    
    public String redirectionIndex(String index)
    {
        String  path = FacesContext.getCurrentInstance().getViewRoot().getViewId();
        if((path.contains("Facelet")) == true)
        {
            return path.substring(0, path.indexOf("Facelet")) + "index.xhtml";
        }
        else
        {
            return index;
        }
    }
    
}
