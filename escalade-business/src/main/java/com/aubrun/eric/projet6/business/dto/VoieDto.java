package com.aubrun.eric.projet6.business.dto;

import java.util.List;

import com.aubrun.eric.projet6.model.bean.Longueur;

public class VoieDto {

    Integer                id;
    String                 nomVoie;
    String                 cotationVoie;
    String                 descriptVoie;
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