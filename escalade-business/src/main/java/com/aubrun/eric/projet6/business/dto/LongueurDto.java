package com.aubrun.eric.projet6.business.dto;

public class LongueurDto {

    Integer id;
    String  nom;
    String  cotation;
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
        return description;
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