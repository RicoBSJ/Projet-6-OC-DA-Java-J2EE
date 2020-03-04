package com.aubrun.eric.projet6.model.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Secteur {

    @Id
    @Column( name = "id" )
    Integer            id;
    @Column( name = "nom" )
    String             nomSecteur;
    @Column( name = "description" )
    String             descriptSecteur;
    @OneToMany
    @JoinColumn( name = "id_secteur" )
    private List<Voie> voies;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNomSecteur() {
        return nomSecteur;
    }

    public void setNomSecteur( String nomSecteur ) {
        this.nomSecteur = nomSecteur;
    }

    public String getDescriptSecteur() {
        return descriptSecteur;
    }

    public void setDescriptSecteur( String descriptSecteur ) {
        this.descriptSecteur = descriptSecteur;
    }

    public List<Voie> getVoies() {
        return voies;
    }

    public void setVoies( List<Voie> voies ) {
        this.voies = voies;
    }
}