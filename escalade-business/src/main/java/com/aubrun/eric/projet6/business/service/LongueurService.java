package com.aubrun.eric.projet6.business.service;

import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.LongueurDAO;
import com.aubrun.eric.projet6.model.bean.Longueur;
import com.aubrun.eric.projet6.model.bean.SearchFormLongueur;

public class LongueurService {

    private LongueurDAO longueurDAO = new LongueurDAO();

    public List<Longueur> searchLenght( SearchFormLongueur searchFormLongueur ) {

        return longueurDAO.rechercheLongueur( searchFormLongueur );
    }

    public void addLenght( Longueur lenght ) {

        longueurDAO.ajouterLongueur( lenght );
    }
}