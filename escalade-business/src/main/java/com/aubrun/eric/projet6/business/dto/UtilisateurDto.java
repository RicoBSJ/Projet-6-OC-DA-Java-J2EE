package com.aubrun.eric.projet6.business.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UtilisateurDto {

    @Id
    @Column( name = "id" )
    Integer id;
    @Column( name = "nom" )
    Integer nomUtil;
    @Column( name = "prenom" )
    String  prenUtil;
    @Column( name = "pseudo" )
    String  pseudo;
    @Column( name = "mail" )
    String  mail;
    @Column( name = "motdepasse" )
    String  motDePasse;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getNomUtil() {
        return nomUtil;
    }

    public void setNomUtil( Integer numUtil ) {
        this.nomUtil = numUtil;
    }

    public String getPrenUtil() {
        return prenUtil;
    }

    public void setPrenUtil( String prenUtil ) {
        this.prenUtil = prenUtil;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo( String pseudo ) {
        this.pseudo = pseudo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail( String mail ) {
        this.mail = mail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse( String motDePasse ) {
        this.motDePasse = motDePasse;
    }
}