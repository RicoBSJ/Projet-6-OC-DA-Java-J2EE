package com.aubrun.eric.projet6.business.dto;

import java.util.List;

public class VoieDto {

    Integer                   id;
    String                    nomVoie;
    String                    cotationVoie;
    String                    descriptVoie;
    private List<LongueurDto> longueurs;

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

    public List<LongueurDto> getLongueurs() {
        return longueurs;
    }

    public void setLongueurs( List<LongueurDto> longueurs ) {
        this.longueurs = longueurs;
    }
}