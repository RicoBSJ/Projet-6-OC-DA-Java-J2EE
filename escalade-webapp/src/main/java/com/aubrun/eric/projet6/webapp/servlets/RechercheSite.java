package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aubrun.eric.projet6.business.service.SiteService;
import com.aubrun.eric.projet6.model.bean.SearchModel;
import com.aubrun.eric.projet6.model.bean.Site;

@WebServlet( "/rechercheSite" )
public class RechercheSite extends HttpServlet {

    private static final long  serialVersionUID = 1L;

    public static final String ATT_SECTEURS     = "secteurs";
    public static final String ATT_VOIES        = "voies";
    public static final String ATT_LONGUEURS    = "longueurs";
    public static final String ATT_SITES        = "sites";
    public static final String VUE              = "/WEB-INF/jsp/rechercheSite.jsp";
    public static final String VUE_RESULT       = "/WEB-INF/jsp/accueil.jsp";

    private SiteService        siteService      = new SiteService();

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page d'inscription */

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        SearchModel searchSite = new SearchModel();
        searchSite.setNom( request.getParameter( "nom" ) );
        searchSite.setPays( request.getParameter( "pays" ) );
        searchSite.setRegion( request.getParameter( "region" ) );
        searchSite.setDescription( request.getParameter( "description" ) );
        searchSite.setCotation( request.getParameter( "cotation" ) );
        searchSite.setHauteur( request.getParameter( "hauteur" ) );
        searchSite.setOrientation( request.getParameter( "orientation" ) );
        searchSite.setSecteurs( request.getParameter( "secteurs" ) );
        searchSite.setVoies( request.getParameter( "voies" ) );
        searchSite.setLongueurs( request.getParameter( "longueurs" ) );

        List<Site> sites = siteService.searchSite( searchSite );

        request.setAttribute( ATT_SITES, sites );

        this.getServletContext().getRequestDispatcher( VUE_RESULT ).forward( request, response );
    }
}
