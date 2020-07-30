package com.aubrun.eric.projet6.business.service;

import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.SecteurDAO;
import com.aubrun.eric.projet6.model.bean.SearchFormSecteur;
import com.aubrun.eric.projet6.model.bean.Secteur;

public class SecteurService {

    private SecteurDAO secteurDAO = new SecteurDAO();

    public List<Secteur> searchSector( SearchFormSecteur searchFormSecteur ) {

        return secteurDAO.rechercheSecteur( searchFormSecteur );
    }

    public void addSector( Secteur sector ) {

        secteurDAO.ajouterSecteur( sector );
    }
}