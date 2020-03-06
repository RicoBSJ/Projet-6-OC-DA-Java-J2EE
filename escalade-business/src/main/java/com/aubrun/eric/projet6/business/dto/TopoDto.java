package com.aubrun.eric.projet6.business.dto;

public class TopoDto {

    Integer id;
    String  nomTopo;
    String  descriptTopo;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNomTopo() {
        return nomTopo;
    }

    public void setNomTopo( String topo ) {
        this.nomTopo = topo;
    }

    public String getDescriptTopo() {
        return descriptTopo;
    }

    public void setDescriptTopo( String descriptTopo ) {
        this.descriptTopo = descriptTopo;
    }
}