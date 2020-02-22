package com.aubrun.eric.projet6.model.bean;

public class Site {

    private Integer id;
    private String  nomSite;
    private String  pays;
    private String  region;
    private String  descripSite;
    private String  cotationSite;
    private Double  hauteur;
    private String  orientation;

    public String getPays() {
        return pays;
    }

    public void setPays( String pays ) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion( String region ) {
        this.region = region;
    }

    public Double getHauteur() {
        return hauteur;
    }

    public void setHauteur( Double hauteur ) {
        this.hauteur = hauteur;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation( String orientation ) {
        this.orientation = orientation;
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNomSite() {
        return nomSite;
    }

    public void setNomSite( String nomSite ) {
        this.nomSite = nomSite;
    }

    public String getDescripSite() {
        return descripSite;
    }

    public void setDescripSite( String descriptSite ) {
        this.descripSite = descriptSite;
    }

    public String getCotationSite() {
        return cotationSite;
    }

    public void setCotationSite( String cotationSite ) {
        this.cotationSite = cotationSite;
    }
}