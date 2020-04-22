package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aubrun.eric.projet6.business.service.SiteService;
import com.aubrun.eric.projet6.model.bean.Site;
import com.aubrun.eric.projet6.webapp.forms.CreationSiteForm;

@WebServlet( "/creationSite" )
public class CreationSite extends HttpServlet {

    private static final long  serialVersionUID = 1L;

    public static final String ATT_SITE         = "site";
    public static final String ATT_FORM         = "form";
    public static final String VUE              = "/WEB-INF/jsp/creerSite.jsp";

    private SiteService        siteService      = new SiteService();

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        /* Préparation de l'objet formulaire */
        CreationSiteForm form = new CreationSiteForm();

        Site site = form.creerSite( request );

        siteService.addSite( site );

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_SITE, site );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}