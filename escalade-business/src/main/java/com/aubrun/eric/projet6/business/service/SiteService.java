package com.aubrun.eric.projet6.business.service;

import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.LongueurDAO;
import com.aubrun.eric.projet6.consumer.DAO.SecteurDAO;
import com.aubrun.eric.projet6.consumer.DAO.SiteDAO;
import com.aubrun.eric.projet6.consumer.DAO.VoieDAO;
import com.aubrun.eric.projet6.model.bean.SearchForm;
import com.aubrun.eric.projet6.model.bean.SearchFormLongueur;
import com.aubrun.eric.projet6.model.bean.SearchFormSecteur;
import com.aubrun.eric.projet6.model.bean.SearchFormVoie;
import com.aubrun.eric.projet6.model.bean.Site;

public class SiteService {

    private SiteDAO     siteDAO     = new SiteDAO();
    private SecteurDAO  secteurDAO  = new SecteurDAO();
    private VoieDAO     voieDAO     = new VoieDAO();
    private LongueurDAO longueurDAO = new LongueurDAO();

    public List<Site> findAll() {

        List<Site> site = siteDAO.recupererSites();
        for ( Site s : site ) {
            System.out.println( s );
        }
        return site;
    }

    public Site findDetails( Integer id ) {

        return siteDAO.afficherDetails( id );
    }

    public void addSite( Site createSite ) {

        siteDAO.ajouterSite( createSite );
    }

    public void deleteSite( Integer idSite ) {

        siteDAO.supprimerSite( idSite );
    }

    public List<Site> searchSite( SearchForm searchForm, SearchFormSecteur searchFormSecteur,
            SearchFormVoie searchFormVoie, SearchFormLongueur searchFormLongueur ) {

        secteurDAO.recherche( searchFormSecteur );
        voieDAO.recherche( searchFormVoie );
        longueurDAO.recherche( searchFormLongueur );
        return siteDAO.recherche( searchForm );
    }

    public void tagOfficialSite( Integer idSite ) {

        Site site = siteDAO.afficherDetails( idSite );
        site.setOfficiel( true );
        siteDAO.modifierSite( site );
    }

    public void modifySite( Site siteToModidy ) {

        siteDAO.modifierSite( siteToModidy );
    }
}