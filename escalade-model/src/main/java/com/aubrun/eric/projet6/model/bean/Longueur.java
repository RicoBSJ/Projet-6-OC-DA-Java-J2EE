package com.aubrun.eric.projet6.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Longueur {

    @GeneratedValue
    @Id
    @Column( name = "id" )
    Integer id;
    @Column( name = "nom" )
    String  nomLongueur;
    @Column( name = "cotation" )
    String  cotationLongueur;
    @Column( name = "description" )
    String  descriptLongueur;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNomLongueur() {
        return nomLongueur;
    }

    public void setNomLongueur( String nomLongueur ) {
        this.nomLongueur = nomLongueur;
    }

    public String getCotationLongueur() {
        return cotationLongueur;
    }

    public void setCotationLongueur( String cotationLongueur ) {
        this.cotationLongueur = cotationLongueur;
    }

    public String getDescriptLongueur() {
        return descriptLongueur;
    }

    public void setDescriptLongueur( String descriptLongueur ) {
        this.descriptLongueur = descriptLongueur;
    }
}