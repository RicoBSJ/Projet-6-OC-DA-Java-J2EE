package com.aubrun.eric.projet6.business.service;

import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.VoieDAO;
import com.aubrun.eric.projet6.model.bean.SearchFormVoie;
import com.aubrun.eric.projet6.model.bean.Voie;

public class VoieService {

    private VoieDAO voieDAO = new VoieDAO();

    public List<Voie> searchWay( SearchFormVoie searchFormVoie ) {

        return voieDAO.rechercheVoie( searchFormVoie );
    }

    public void addWay( Voie way ) {

        voieDAO.ajouterVoie( way );
    }
}