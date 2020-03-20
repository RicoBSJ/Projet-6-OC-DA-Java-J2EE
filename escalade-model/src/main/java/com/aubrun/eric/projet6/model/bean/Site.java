package com.aubrun.eric.projet6.model.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
public class Site {

    @Id
    @Column( name = "id" )
    private Integer       id;
    @Column( name = "nom" )
    private String        nom;
    @Column( name = "pays" )
    private String        pays;
    @Column( name = "region" )
    private String        region;
    @Column( name = "description", columnDefinition = "text" )
    private String        description;
    @Column( name = "cotation" )
    private String        cotation;
    @Column( name = "hauteur" )
    private Double        hauteur;
    @Column( name = "orientation" )
    private String        orientation;
    @OneToMany
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "id_site" )
    private List<Photo>   photos;
    @OneToMany
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "id_site" )
    private List<Secteur> secteurs;

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

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos( List<Photo> photos ) {
        this.photos = photos;
    }

    public List<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs( List<Secteur> secteurs ) {
        this.secteurs = secteurs;
    }

}