package com.aubrun.eric.projet6.business.dto;

import java.util.List;

public class SecteurDto {

    Integer               id;
    String                nom;
    String                description;
    private List<VoieDto> voies;

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

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public List<VoieDto> getVoies() {
        return voies;
    }

    public void setVoies( List<VoieDto> voies ) {
        this.voies = voies;
    }
}