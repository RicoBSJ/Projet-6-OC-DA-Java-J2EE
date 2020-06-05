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
public class Topo {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Integer     id;
    @Column( name = "nom" )
    private String      nom;
    @Column( name = "description", columnDefinition = "text" )
    private String      description;
    @Column( name = "lieu" )
    private String      lieu;
    @Column( name = "dateParution" )
    private Date        dateParution;
    @ManyToOne
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "id_site" )
    private Site        site;
    @ManyToOne
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "id_utilisateur" )
    private Utilisateur utilisateur;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String topo ) {
        this.nom = topo;
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

    public Date getDateParution() {
        return dateParution;
    }

    public void setDateParution( Date dateParution ) {
        this.dateParution = dateParution;
    }

    public Site getSite() {
        return site;
    }

    public void setSite( Site site ) {
        this.site = site;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur( Utilisateur utilisateur ) {
        this.utilisateur = utilisateur;
    }
}