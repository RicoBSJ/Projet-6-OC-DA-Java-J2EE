package com.aubrun.eric.projet6.model.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
public class Secteur {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Integer    id;
    @Column( name = "nom" )
    private String     nom;
    @Column( name = "description" )
    private String     description;
    @OneToMany
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "id_voie" )
    private List<Voie> voies;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
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

    public List<Voie> getVoies() {
        return voies;
    }

    public void setVoies( List<Voie> voies ) {
        this.voies = voies;
    }
}