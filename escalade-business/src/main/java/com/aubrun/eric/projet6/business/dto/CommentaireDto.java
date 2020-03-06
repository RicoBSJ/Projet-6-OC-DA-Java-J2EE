package com.aubrun.eric.projet6.business.dto;

public class CommentaireDto {

    Integer id;
    String  commentaire;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire( String commentaire ) {
        this.commentaire = commentaire;
    }
}