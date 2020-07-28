package com.aubrun.eric.projet6.model.bean;

import javax.servlet.http.HttpServletRequest;

public class SearchFormLongueur {

    private String nom;
    private String cotation;
    private String description;

    public SearchFormLongueur( HttpServletRequest request ) {
        this.nom = request.getParameter( "nom" );
        this.cotation = request.getParameter( "cotation" );
        this.description = request.getParameter( "description" );
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
