package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.business.service.SiteService;
import com.aubrun.eric.projet6.model.bean.Site;
import com.aubrun.eric.projet6.model.bean.Utilisateur;
import com.aubrun.eric.projet6.webapp.forms.RechercheSiteForm;

@WebServlet( "/rechercheSite" )
public class RechercheSite extends HttpServlet {

    private static final long  serialVersionUID = 1L;

    public static final String ATT_SITE         = "site";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE              = "/WEB-INF/jsp/rechercheSite.jsp";

    private SiteService        siteService      = new SiteService();

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page d'inscription */

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        /* Préparation de l'objet formulaire */
        RechercheSiteForm form = new RechercheSiteForm();

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        Utilisateur utilisateur = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( utilisateur == null ) {
            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        } else {
            Site site = form.rechercherSite( request );

            siteService.searchSiteByName( site.getNom() );
            siteService.searchSiteByCountry( site.getPays() );
            siteService.searchSiteByRegion( site.getRegion() );
            siteService.searchSiteByDescription( site.getDescription() );
            siteService.searchSiteByQuotation( site.getCotation() );
            siteService.searchSiteByHeight( site.getHauteur() );
            siteService.searchSiteByDirection( site.getOrientation() );
            siteService.findAll();

            request.setAttribute( ATT_FORM, form );
            request.setAttribute( ATT_SITE, site );
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
