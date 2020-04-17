package com.aubrun.eric.projet6.model.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Utilisateur {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Integer   id;
    @Column( name = "adresse" )
    private String    adresse;
    @Column( name = "dateinscription" )
    private Timestamp dateInscription;
    @Column( name = "email" )
    private String    email;
    @Column( name = "motdepasse" )
    private String    motDePasse;
    @Column( name = "nom" )
    private String    nom;
    @Column( name = "prenom" )
    private String    prenom;
    @Column( name = "telephone" )
    private String    telephone;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }

    public Timestamp getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription( Timestamp dateInscription ) {
        this.dateInscription = dateInscription;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse( String motDePasse ) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone( String telephone ) {
        this.telephone = telephone;
    }
}