package com.aubrun.eric.projet6.business.service;

import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.LongueurDAO;
import com.aubrun.eric.projet6.consumer.DAO.SecteurDAO;
import com.aubrun.eric.projet6.consumer.DAO.SiteDAO;
import com.aubrun.eric.projet6.consumer.DAO.VoieDAO;
import com.aubrun.eric.projet6.model.bean.Longueur;
import com.aubrun.eric.projet6.model.bean.SearchForm;
import com.aubrun.eric.projet6.model.bean.Secteur;
import com.aubrun.eric.projet6.model.bean.Site;
import com.aubrun.eric.projet6.model.bean.Voie;

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

        Secteur sector = new Secteur();
        Voie way = new Voie();
        Longueur lenght = new Longueur();
        secteurDAO.ajouterSecteur( sector );
        voieDAO.ajouterVoie( way );
        longueurDAO.ajouterLongueur( lenght );
        siteDAO.ajouterSite( createSite );
    }

    public void deleteSite( Integer idSite ) {

        siteDAO.supprimerSite( idSite );
    }

    public List<Site> searchSite( SearchForm searchForm ) {

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