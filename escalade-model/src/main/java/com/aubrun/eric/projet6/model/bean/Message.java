package com.aubrun.eric.projet6.model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
public class Message {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Integer     id;
    @Column( name = "message" )
    private String      message;
    @OneToOne( cascade = CascadeType.ALL )
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "id_destinataire" )
    private Utilisateur destinataire;
    @OneToOne( cascade = CascadeType.ALL )
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "id_emetteur" )
    private Utilisateur emetteur;
    @OneToOne( cascade = CascadeType.ALL )
    @LazyCollection( LazyCollectionOption.FALSE )
    @JoinColumn( name = "id_topo" )
    private Topo        topo;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
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
}