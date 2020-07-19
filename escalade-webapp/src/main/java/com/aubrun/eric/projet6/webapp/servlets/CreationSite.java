package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.business.service.SiteService;
import com.aubrun.eric.projet6.model.bean.Photo;
import com.aubrun.eric.projet6.model.bean.Site;
import com.aubrun.eric.projet6.model.bean.Utilisateur;
import com.aubrun.eric.projet6.webapp.forms.CreationSiteForm;
import com.aubrun.eric.projet6.webapp.forms.UploadForm;

@WebServlet( "/CreationSite" )
public class CreationSite extends HttpServlet {

    private static final long   serialVersionUID = 1L;
    private static final String ATT_SITE         = "site";
    private static final String ATT_PHOTO        = "photo";
    private static final String ATT_FORM         = "form";
    private static final String ATT_SESSION_USER = "sessionUtilisateur";
    private static final String VUE              = "/WEB-INF/jsp/creerSite.jsp";
    private static final String CHEMIN_FICHIERS  = "/Users/ricobsj/fichiers/";
    private SiteService         siteService      = new SiteService();

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Utilisateur utilisateur = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( utilisateur == null ) {
            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        String chemin = this.getServletConfig().getInitParameter( CHEMIN_FICHIERS );

        CreationSiteForm form = new CreationSiteForm();
        UploadForm formU = new UploadForm();

        HttpSession session = request.getSession();

        Utilisateur utilisateur = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( utilisateur == null ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        } else {

            Site site = form.creerSite( request );
            Photo photo = formU.enregistrerFichier( request, chemin );

            if ( site.getPhotos() == null ) {

                site.setPhotos( new ArrayList<Photo>() );
            }

            site.getPhotos().add( photo );

            siteService.addSite( site );

            request.setAttribute( ATT_FORM, form );
            request.setAttribute( ATT_SITE, site );
            request.setAttribute( ATT_PHOTO, photo );
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}