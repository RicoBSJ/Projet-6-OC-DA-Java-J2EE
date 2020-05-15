package com.aubrun.eric.projet6.model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
public class Commentaire {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Integer     idCommentaire;
    @Column( name = "contenu", columnDefinition = "text" )
    private String      contenu;
    @Column( name = "titre" )
    private String      titre;
    @Column( name = "date" )
    private Date        date;
    @ManyToOne
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "id_utilisateur" )
    private Utilisateur utilisateur;

    public Integer getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire( Integer idCommentaire ) {
        this.idCommentaire = idCommentaire;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu( String contenu ) {
        this.contenu = contenu;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre( String titre ) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate( Date date ) {
        this.date = date;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur( Utilisateur utilisateur ) {
        this.utilisateur = utilisateur;
    }
}