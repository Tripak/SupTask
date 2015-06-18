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
import javax.persistence.ManyToMany;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@XmlRootElement
@Table(name = "User") // Nom de la table
public class UserEntity implements Serializable {
    
    private static final long serialVersionUID = 1L; // permet à la JVM d'identifier les objets lorsqu'elle les sérialise ou désérialise
    @Id //Annotation Permettant de passer l'attribut Id en tant que clef primaire
    @GeneratedValue(strategy = GenerationType.AUTO) //Annotation définnissant le type de generation
    @Column(name ="id") //Annotation définnissant le non de la colonne et si la valeur null est autorisé
    private Long Id;
    
    @Column(name ="firstName", length=50, nullable=false)// Propriété lenght pour definir la longeur de l'attribut
    @NotNull(message = "Veuillez saisir un nom")
    private String firstName;
    
    @Column(name ="lastName", length=50, nullable=false)// Propriété lenght pour definir la longeur de l'attribut
    @NotNull(message = "Veuillez saisir un prenom")
    private String lastName;
    
    @Column(name ="login", length=50,nullable=false)
    @NotNull(message = "Veuillez saisir un login")
    private String login;
    
    @Column(name ="password", length=50,nullable=false)
    @NotNull(message = "Veuillez saisir un mot de passe")
    @Size(min = 6, message = "Veuillez saisir au minimu 6 caractère")
    @Pattern(regexp = ".*(?=.{6,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*", message = "Le mot de passe doit contenir au moins 6 carractère, une majuscule, un chiffre")
    private String password;
    
    @Column(name ="email", length=50,nullable=false)
    @NotNull(message = "Veuillez saisir une adresse mail")
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "Le mail saisi n'est pas valide")
    private String email;
    
    @Column(name ="postal", precision=5,nullable=false)
    @NotNull(message = "Veuillez saisir un code postal")
    @Pattern(regexp = "\\d{5}", message = "Veuillez saisir un code postal valide")
    private String postal;
     
    @Column(name ="phoneNumber", precision=10,nullable=false)
    @NotNull(message = "Veuillez saisir un numero de telephone")
    @Pattern(regexp = "\\d{10}", message = "Veuillez saisir un numero de telephone valide")
    private String phoneNumber;
    
    @ManyToMany(fetch=FetchType.LAZY) // représente la cardinalité entre les entités User et Car : 1 ou n voiture appartient a 1 utilisateur et non le contraire
    private Collection<ProjectEntity> projects; // Attribut représentant la cléf étrangère

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Collection<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(Collection<ProjectEntity> projects) {
        this.projects = projects;
    }
    
}