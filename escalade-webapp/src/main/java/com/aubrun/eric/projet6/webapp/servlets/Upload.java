package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aubrun.eric.projet6.model.bean.Photo;
import com.aubrun.eric.projet6.webapp.forms.UploadForm;

@WebServlet( "/upload" )
public class Upload extends HttpServlet {

    private static final long  serialVersionUID = 1L;

    public static final String CHEMIN           = "chemin";

    public static final String ATT_PHOTO        = "photo";
    public static final String ATT_FORM         = "form";

    public static final String VUE              = "/WEB-INF/jsp/upload.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page d'upload */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /*
         * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
         * dans le web.xml
         */
        String chemin = this.getServletConfig().getInitParameter( CHEMIN );

        /* Préparation de l'objet formulaire */
        UploadForm form = new UploadForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Photo photo = form.enregistrerFichier( request, chemin );

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_PHOTO, photo );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}