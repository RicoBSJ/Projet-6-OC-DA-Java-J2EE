package com.aubrun.eric.projet6.model.bean;

import javax.servlet.http.HttpServletRequest;

public class SearchFormComTopo {

    private String commentaire;

    public SearchFormComTopo( HttpServletRequest request ) {
        this.commentaire = request.getParameter( "commentaire" );
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire( String commentaire ) {
        this.commentaire = commentaire;
    }
}