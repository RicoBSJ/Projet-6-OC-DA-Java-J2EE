package com.aubrun.eric.projet6.business.service;

import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.SiteDAO;
import com.aubrun.eric.projet6.model.bean.Site;

public class SiteService {

    private SiteDAO siteDAO = new SiteDAO();

    public List<Site> findAll() {

        List<Site> site = siteDAO.recupererSites();
        for ( Site s : site ) {
            System.out.println( s );
        }
        return site;
    }

    public Site findDetails( Integer id ) {

        Site site = siteDAO.afficherDetails( id );
        return site;
    }

    public void addSite( Site createSite ) {

        siteDAO.ajouterSite( createSite );
    }

    public Site deleteSite( Integer id ) {

        Site site = siteDAO.supprimerSite( id );
        return site;
    }

    public Site searchSiteByName( String nom ) {

        Site site = siteDAO.chercherSiteParNom( nom );
        return site;
    }

    public Site searchSiteByCountry( String pays ) {

        Site site = siteDAO.chercherSiteParPays( pays );
        return site;
    }

    public Site searchSiteByRegion( String region ) {

        Site site = siteDAO.chercherSiteParRegion( region );
        return site;
    }

    public Site getSiteByDescription( String description ) {

        Site site = siteDAO.chercherSiteParDescription( description );
        return site;
    }

    public Site searchSiteByQuotation( String cotation ) {

        Site site = siteDAO.chercherSiteParCotation( cotation );
        return site;
    }

    public Site searchSiteByHeight( String hauteur ) {

        Site site = siteDAO.chercherSiteParHauteur( hauteur );
        return site;
    }

    public Site searchSiteByDirection( String orientation ) {

        Site site = siteDAO.chercherSiteParOrientation( orientation );
        return site;
    }
}