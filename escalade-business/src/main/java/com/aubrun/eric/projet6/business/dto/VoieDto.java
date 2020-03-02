package com.aubrun.eric.projet6.business.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class VoieDto {

    @Id
    @Column( name = "id" )
    Integer id;
    @Column( name = "nom" )
    String  nomVoie;
    @Column( name = "cotation" )
    String  cotationVoie;
    @Column( name = "description" )
    String  descriptVoie;

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
}