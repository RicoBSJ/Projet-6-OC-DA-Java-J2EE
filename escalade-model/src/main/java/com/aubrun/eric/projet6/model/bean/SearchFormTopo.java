package com.aubrun.eric.projet6.model.bean;

import javax.servlet.http.HttpServletRequest;

public class SearchFormTopo {

    private String nom;
    private String description;
    private String lieu;
    private String dateParution;

    public SearchFormTopo( HttpServletRequest request ) {
        this.nom = request.getParameter( "nom" );
        this.description = request.getParameter( "description" );
        this.lieu = request.getParameter( "lieu" );
        this.dateParution = request.getParameter( "dateParution" );
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

    public String getLieu() {
        return lieu;
    }

    public void setLieu( String lieu ) {
        this.lieu = lieu;
    }

    public String getDateParution() {
        return dateParution;
    }

    public void setDateParution( String dateParution ) {
        this.dateParution = dateParution;
    }
}