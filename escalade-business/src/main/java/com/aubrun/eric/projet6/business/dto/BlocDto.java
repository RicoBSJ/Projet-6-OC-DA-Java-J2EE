package com.aubrun.eric.projet6.business.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BlocDto {

    @Id
    @Column( name = "id" )
    Integer id;
    @Column( name = "nom" )
    String  nomBloc;
    @Column( name = "description" )
    String  descriptBloc;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNomBloc() {
        return nomBloc;
    }

    public void setNomBloc( String nomBloc ) {
        this.nomBloc = nomBloc;
    }

    public String getDescriptBloc() {
        return descriptBloc;
    }

    public void setDescriptBloc( String descriptBloc ) {
        this.descriptBloc = descriptBloc;
    }
}