package com.aubrun.eric.projet6.business.service;

import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.SiteDAO;
import com.aubrun.eric.projet6.model.bean.SearchModel;
import com.aubrun.eric.projet6.model.bean.Site;

public class SiteService {

    private SiteDAO siteDAO = new SiteDAO();

    public List<Site> findAll() {

        List<Site> site = siteDAO.recupererSites();
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

    public List<Site> searchSite( SearchModel searchForm ) {

        return siteDAO.recherche( searchForm );
    }

    public void tagOfficialSite( Integer idSite ) {

        Site site = siteDAO.afficherDetails( idSite );
        if ( site.getOfficiel() == false ) {
            site.setOfficiel( true );
        } else {
            site.setOfficiel( false );
        }
        siteDAO.modifierSite( site );
    }

    public void modifySite( Site siteToModidy ) {

        siteDAO.modifierSite( siteToModidy );
    }
}