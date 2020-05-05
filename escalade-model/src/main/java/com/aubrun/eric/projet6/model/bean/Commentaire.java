package com.aubrun.eric.projet6.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Commentaire {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Integer idCommentaire;
    @Column( name = "commentaire", columnDefinition = "text" )
    private String  commentaire;

    public Integer getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire( Integer idCommentaire ) {
        this.idCommentaire = idCommentaire;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire( String commentaire ) {
        this.commentaire = commentaire;
    }
}