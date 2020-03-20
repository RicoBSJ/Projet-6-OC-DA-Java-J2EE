package com.aubrun.eric.projet6.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Longueur {

    @GeneratedValue
    @Id
    @Column( name = "id" )
    Integer id;
    @Column( name = "nom" )
    String  nom;
    @Column( name = "cotation" )
    String  cotation;
    @Column( name = "description" )
    String  description;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation( String cotation ) {
        this.cotation = cotation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }
}