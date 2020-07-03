package com.aubrun.eric.projet6.model.bean;

public class Message {

    Integer     id;
    Utilisateur destinataire;
    Utilisateur emetteur;
    Topo        topo;
    String      message;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Utilisateur getDestinataire() {
        return destinataire;
    }

    public void setDestinataire( Utilisateur destinataire ) {
        this.destinataire = destinataire;
    }

    public Utilisateur getEmetteur() {
        return emetteur;
    }

    public void setEmetteur( Utilisateur emetteur ) {
        this.emetteur = emetteur;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo( Topo topo ) {
        this.topo = topo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }

}
