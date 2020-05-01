package com.aubrun.eric.projet6.model.bean;

import javax.servlet.http.HttpServletRequest;

public class SearchForm {

    private String nom;
    private String pays;
    private String region;
    private String description;
    private String cotation;
    private String hauteur;
    private String orientation;

    public SearchForm( HttpServletRequest request ) {
        this.nom = request.getParameter( "nom" );
        this.pays = request.getParameter( "pays" );
        this.region = request.getParameter( "region" );
        this.description = request.getParameter( "description" );
        this.cotation = request.getParameter( "cotation" );
        this.hauteur = request.getParameter( "hauteur" );
        this.orientation = request.getParameter( "orientation" );
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
}
