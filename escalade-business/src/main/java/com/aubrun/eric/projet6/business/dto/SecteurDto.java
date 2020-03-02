package com.aubrun.eric.projet6.business.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SecteurDto {

    @Id
    @Column( name = "id" )
    Integer id;
    @Column( name = "nom" )
    String  nomSecteur;
    @Column( name = "description" )
    String  descriptSecteur;

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
}