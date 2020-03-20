package com.aubrun.eric.projet6.model.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
public class Voie {

    @GeneratedValue
    @Id
    @Column( name = "id" )
    Integer                id;
    @Column( name = "nom" )
    String                 nomVoie;
    @Column( name = "cotation" )
    String                 cotationVoie;
    @Column( name = "description" )
    String                 descriptVoie;
    @OneToMany
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "id_voie" )
    private List<Longueur> longueurs;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie( String nomVoie ) {
        this.nomVoie = nomVoie;
    }

    public String getCotationVoie() {
        return cotationVoie;
    }

    public void setCotationVoie( String cotationVoie ) {
        this.cotationVoie = cotationVoie;
    }

    public String getDescriptVoie() {
        return descriptVoie;
    }

    public void setDescriptVoie( String descriptVoie ) {
        this.descriptVoie = descriptVoie;
    }

    public List<Longueur> getLongueurs() {
        return longueurs;
    }

    public void setLongueurs( List<Longueur> longueurs ) {
        this.longueurs = longueurs;
    }
}