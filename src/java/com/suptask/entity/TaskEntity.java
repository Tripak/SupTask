/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suptask.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.NotNull;


@Entity
@XmlRootElement
@Table(name = "Task") // Nom de la table
public class TaskEntity implements Serializable {
    
    public enum Level { Critical, High, Moderate, Low }
    
    private static final long serialVersionUID = 1L; // permet à la JVM d'identifier les objets lorsqu'elle les sérialise ou désérialise
    @Id //Annotation Permettant de passer l'attribut Id en tant que clef primaire
    @GeneratedValue(strategy = GenerationType.AUTO) //Annotation définnissant le type de generation
    @Column(name ="id") //Annotation définnissant le non de la colonne et si la valeur null est autorisé
    private Long Id;
    
    @Column(name ="title", length=50, nullable=false) // Propriété lenght pour definir la longeur de l'attribut
    @NotNull(message = "Veuillez saisir un titre à votre tache")
    private String title;
    
    @Column(name ="description", length=100, nullable=false)
    @NotNull(message = "Veuillez saisir un descriptif")
    private String description;
    
    @Column(name ="level", length=13, nullable=false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Veuiilez sélectionner un niveau de priorité")
    private Level level;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity FK_idUser;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private ProjectEntity FK_idProject;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public UserEntity getFK_idUser() {
        return FK_idUser;
    }

    public void setFK_idUser(UserEntity FK_idUser) {
        this.FK_idUser = FK_idUser;
    }

    public ProjectEntity getFK_idpROJECT() {
        return FK_idProject;
    }

    public void setFK_idpROJECT(ProjectEntity FK_idProject) {
        this.FK_idProject = FK_idProject;
    }
    
}
