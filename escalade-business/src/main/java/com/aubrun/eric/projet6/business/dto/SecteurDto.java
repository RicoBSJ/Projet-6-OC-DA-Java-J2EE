package com.aubrun.eric.projet6.business.dto;

import java.util.List;

import com.aubrun.eric.projet6.model.bean.Voie;

public class SecteurDto {

    Integer            id;
    String             nomSecteur;
    String             descriptSecteur;
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