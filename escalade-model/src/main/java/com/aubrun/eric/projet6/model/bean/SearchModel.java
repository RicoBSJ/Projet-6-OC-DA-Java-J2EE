package com.aubrun.eric.projet6.model.bean;

public class SearchModel {

    private String nom;
    private String pays;
    private String region;
    private String description;
    private String cotation;
    private String hauteur;
    private String orientation;
    private String secteurs;
    private String voies;
    private String longueurs;

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays( String pays ) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion( String region ) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation( String cotation ) {
        this.cotation = cotation;
    }

    public String getHauteur() {
        return hauteur;
    }

    public void setHauteur( String hauteur ) {
        this.hauteur = hauteur;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation( String orientation ) {
        this.orientation = orientation;
    }

    public String getSecteurs() {
        return secteurs;
    }

    public void setSecteurs( String secteurs ) {
        this.secteurs = secteurs;
    }

    public String getVoies() {
        return voies;
    }

    public void setVoies( String voies ) {
        this.voies = voies;
    }

    public String getLongueurs() {
        return longueurs;
    }

    public void setLongueurs( String longueurs ) {
        this.longueurs = longueurs;
    }
}