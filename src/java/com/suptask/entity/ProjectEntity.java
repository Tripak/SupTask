/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suptask.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.NotNull;


@Entity
@XmlRootElement
@Table(name = "Project") // Nom de la table
public class ProjectEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;// permet à la JVM d'identifier les objets lorsqu'elle les sérialise ou désérialise
    
    @Id  //Annotation Permettant de passer l'attribut Id en tant que clef primaire
    @GeneratedValue(strategy = GenerationType.AUTO) //Annotation définnissant le type de generation
    @Column(name ="id") //Annotation définnissant le non de la colonne et si la valeur null est autorisé
    private Long Id;
    
    @Column(name ="title", length=50, nullable=false) // Propriété lenght pour definir la longeur de l'attribut
    @NotNull(message = "Veuillez saisir un nom de projet")
    private String title;
    
    @ManyToMany(fetch=FetchType.LAZY) // représente la cardinalité entre les entités User et Car : 1 ou n voiture appartient a 1 utilisateur et non le contraire
    private Collection<UserEntity> users; // Attribut représentant la cléf étrangère
    
    @OneToMany(fetch=FetchType.LAZY) // représente la cardinalité entre les entités User et Car : 1 ou n voiture appartient a 1 utilisateur et non le contraire
    private Collection<TaskEntity> tasks; // Attribut représentant la cléf étrangère

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserEntity> users) {
        this.users = users;
    }

    public Collection<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<TaskEntity> tasks) {
        this.tasks = tasks;
    }
    
}
