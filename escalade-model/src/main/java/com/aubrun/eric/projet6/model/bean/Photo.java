package com.aubrun.eric.projet6.model.bean;

import java.util.List;

import javax.persistence.CascadeType;
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
public class Photo {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Integer    id;
    @Column( name = "nom" )
    private String     nomPhoto;
    @Column( name = "chemin" )
    private String     cheminPhoto;
    @OneToMany( cascade = CascadeType.ALL )
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "id_site" )
    private List<Site> sites;

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

    public List<Site> getSites() {
        return sites;
    }

    public void setSites( List<Site> sites ) {
        this.sites = sites;
    }
}