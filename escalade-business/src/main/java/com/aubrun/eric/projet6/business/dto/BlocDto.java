package com.aubrun.eric.projet6.business.dto;

public class BlocDto {

    Integer id;
    String  nomBloc;
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