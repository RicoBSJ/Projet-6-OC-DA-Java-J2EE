package com.aubrun.eric.projet6.business.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CommentaireDto {

    @Id
    @Column( name = "id" )
    Integer id;
    @Column( name = "commentaire" )
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