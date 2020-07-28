package com.aubrun.eric.projet6.model.bean;

import javax.servlet.http.HttpServletRequest;

public class SearchFormSecteur {

    private String nom;
    private String description;

    public SearchFormSecteur( HttpServletRequest request ) {
        this.nom = request.getParameter( "nom" );
        this.description = request.getParameter( "description" );
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
}
