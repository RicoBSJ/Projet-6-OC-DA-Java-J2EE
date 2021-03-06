package com.aubrun.eric.projet6.model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Message {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Integer     id;
    @Column( name = "message" )
    private String      message;
    @Column( name = "statut" )
    private Boolean     statut;
    @ManyToOne( cascade = { CascadeType.ALL } )
    @JoinColumn( name = "destinataire" )
    private Utilisateur destinataire;
    @ManyToOne( cascade = { CascadeType.ALL } )
    @JoinColumn( name = "emetteur" )
    private Utilisateur emetteur;
    @ManyToOne( cascade = { CascadeType.ALL } )
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

	public Boolean getStatut() {
		return statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
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