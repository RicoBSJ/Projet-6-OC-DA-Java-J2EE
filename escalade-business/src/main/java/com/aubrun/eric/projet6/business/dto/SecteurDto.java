package com.aubrun.eric.projet6.business.dto;

import java.util.List;

public class SecteurDto {

    Integer               id;
    String                nomSecteur;
    String                descriptSecteur;
    private List<VoieDto> voies;

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

    public List<VoieDto> getVoies() {
        return voies;
    }

    public void setVoies( List<VoieDto> voies ) {
        this.voies = voies;
    }
}