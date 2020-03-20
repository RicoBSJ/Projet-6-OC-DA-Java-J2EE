package com.aubrun.eric.projet6.business.dto;

import java.util.List;

public class VoieDto {

    Integer                   id;
    String                    nom;
    String                    cotation;
    String                    description;
    private List<LongueurDto> longueurs;

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

    public List<LongueurDto> getLongueurs() {
        return longueurs;
    }

    public void setLongueurs( List<LongueurDto> longueurs ) {
        this.longueurs = longueurs;
    }
}