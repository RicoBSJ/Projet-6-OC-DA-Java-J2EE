package com.aubrun.eric.projet6.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Photo {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Integer id;
    @Column( name = "nom" )
    private String  nomPhoto;
    @Column( name = "chemin" )
    private String  cheminPhoto;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNomPhoto() {
        return nomPhoto;
    }

    public void setNomPhoto( String nomPhoto ) {
        this.nomPhoto = nomPhoto;
    }

    public String getCheminPhoto() {
        return cheminPhoto;
    }

    public void setCheminPhoto( String cheminPhoto ) {
        this.cheminPhoto = cheminPhoto;
    }
}