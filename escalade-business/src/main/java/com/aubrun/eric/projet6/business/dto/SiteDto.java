package com.aubrun.eric.projet6.business.dto;

import java.util.List;

public class SiteDto {

    private Integer          id;
    private String           nom;
    private String           pays;
    private String           region;
    private String           description;
    private String           cotation;
    private Double           hauteur;
    private String           orientation;
    private List<PhotoDto>   photos;
    private List<SecteurDto> secteurs;

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

    public Double getHauteur() {
        return hauteur;
    }

    public void setHauteur( Double hauteur ) {
        this.hauteur = hauteur;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation( String orientation ) {
        this.orientation = orientation;
    }

    public List<PhotoDto> getPhotos() {
        return photos;
    }

    public void setPhotos( List<PhotoDto> photos ) {
        this.photos = photos;
    }

    public List<SecteurDto> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs( List<SecteurDto> secteurs ) {
        this.secteurs = secteurs;
    }
}