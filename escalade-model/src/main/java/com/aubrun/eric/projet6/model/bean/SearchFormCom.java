package com.aubrun.eric.projet6.model.bean;

import javax.servlet.http.HttpServletRequest;

public class SearchFormCom {

    private String commentaire;

    public SearchFormCom( HttpServletRequest request ) {
        this.commentaire = request.getParameter( "commentaire" );
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire( String commentaire ) {
        this.commentaire = commentaire;
    }
}