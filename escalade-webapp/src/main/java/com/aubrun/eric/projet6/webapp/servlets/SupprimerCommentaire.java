package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.business.service.CommentaireService;
import com.aubrun.eric.projet6.model.bean.Commentaire;
import com.aubrun.eric.projet6.model.bean.Utilisateur;
import com.aubrun.eric.projet6.webapp.forms.SupprimerCommentaireForm;

@WebServlet( "/SupprimerCommentaire" )
public class SupprimerCommentaire extends HttpServlet {

    private static final long  serialVersionUID   = 1L;

    public static final String ATT_COMMENTAIRE    = "commentaire";
    public static final String ATT_FORM           = "form";
    public static final String ATT_SESSION_USER   = "sessionUtilisateur";
    public static final String VUE                = "/WEB-INF/jsp/detailsSite.jsp";

    private CommentaireService commentaireService = new CommentaireService();

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page d'inscription */

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

        /* Préparation de l'objet formulaire */
        SupprimerCommentaireForm form = new SupprimerCommentaireForm();

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        } else {

            Commentaire commentaire = form.supprimerCommentaire( request );
            Integer id = Integer.parseInt( request.getParameter( "id" ) );
            commentaire.setIdCommentaire( id );
            commentaire.setUtilisateur( connectedUser );
            commentaire.setDate( new Date() );

            commentaireService.deleteCommentaire( id );

            request.setAttribute( ATT_FORM, form );
            session.setAttribute( ATT_SESSION_USER, connectedUser );
            request.setAttribute( ATT_COMMENTAIRE, commentaire );

            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
    }
}