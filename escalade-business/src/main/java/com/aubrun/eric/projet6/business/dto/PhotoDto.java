package com.aubrun.eric.projet6.business.dto;

public class PhotoDto {

    private Long   id;
    private String nomPhoto;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getNomPhoto() {
        return nomPhoto;
    }

    public void setNomPhoto( String nomPhoto ) {
        this.nomPhoto = nomPhoto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl( String url ) {
        this.url = url;
    }
}