package com.aubrun.eric.projet6.webapp.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.aubrun.eric.projet6.business.service.SiteService;
import com.aubrun.eric.projet6.model.bean.Photo;
import com.aubrun.eric.projet6.model.bean.Site;
import com.aubrun.eric.projet6.model.bean.Utilisateur;
import com.aubrun.eric.projet6.webapp.forms.CreationSiteForm;

@WebServlet( "/CreationSite" )
public class CreationSite extends HttpServlet {

    private static final long   serialVersionUID = 1L;
    private static final String ATT_SITE         = "site";
    private static final String ATT_PHOTO        = "photo";
    private static final String ATT_FORM         = "form";
    private static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String  CHEMIN_FICHIERS  = "/Users/ricobsj/git/Projet-6-OC-DA-Java-J2EE/escalade-webapp/WebContent/images/";
    private static final String VUE              = "/WEB-INF/jsp/creerSite.jsp";
    private static final int    TAILLE_TAMPON    = 10240;
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

        Part part = request.getPart( "cheminPhoto" );
        String nomFichier = getNomFichier( part );

        CreationSiteForm form = new CreationSiteForm();

        HttpSession session = request.getSession();

        Utilisateur utilisateur = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( utilisateur == null ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        } else {

            Site site = form.creerSite( request );
            if ( nomFichier != null && !nomFichier.isEmpty() ) {
                String nomChamp = part.getName();
                // Corrige un bug du fonctionnement d'Internet Explorer
                nomFichier = nomFichier.substring( nomFichier.lastIndexOf( '/' ) + 1 )
                        .substring( nomFichier.lastIndexOf( '\\' ) + 1 );

                // On écrit définitivement le fichier sur le disque
                ecrireFichier( part, nomFichier, CHEMIN_FICHIERS );

                request.setAttribute( nomChamp, nomFichier );
            }

            Photo photo = new Photo();
            photo.setCheminPhoto( "images/" + nomFichier );
            photo.setNomPhoto( nomFichier );
            if ( site.getPhotos() == null ) {
                site.setPhotos( new ArrayList<>() );
            }
            site.getPhotos().add( photo );

            // Secteur sector = new Secteur();
            // Voie way = new Voie();
            // Longueur lenght = new Longueur();
            // sector.setDescription( request.getParameter( "description" ) );
            // way.setDescription( request.getParameter( "description" ) );
            // lenght.setDescription( request.getParameter( "description" ) );

            siteService.addSite( site );

            request.setAttribute( ATT_FORM, form );
            request.setAttribute( ATT_SITE, site );
            request.setAttribute( ATT_PHOTO, photo );
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {

        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream( part.getInputStream(), TAILLE_TAMPON );
            sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin + nomFichier ) ), TAILLE_TAMPON );

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ( ( longueur = entree.read( tampon ) ) > 0 ) {
                sortie.write( tampon, 0, longueur );
            }
        } finally {
            try {
                sortie.close();
            } catch ( IOException ignore ) {
            }
            try {
                entree.close();
            } catch ( IOException ignore ) {
            }
        }
    }

    private static String getNomFichier( Part part ) {

        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }
}