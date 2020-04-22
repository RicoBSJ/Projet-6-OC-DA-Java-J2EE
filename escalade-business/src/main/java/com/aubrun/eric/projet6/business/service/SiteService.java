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
}