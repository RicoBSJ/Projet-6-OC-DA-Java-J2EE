package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.business.service.CommentaireService;
import com.aubrun.eric.projet6.model.bean.Commentaire;
import com.aubrun.eric.projet6.model.bean.Utilisateur;
import com.aubrun.eric.projet6.webapp.forms.AjouterCommentaireForm;

@WebServlet( "/AjouterCommentaire" )
public class AjouterCommentaire extends HttpServlet {

    private static final long  serialVersionUID   = 1L;

    public static final String ATT_COMMENTAIRE    = "commentaire";
    public static final String ATT_FORM           = "form";
    public static final String ATT_SESSION_USER   = "sessionUtilisateur";
    public static final String VUE                = "/WEB-INF/jsp/ajouterCommentaire.jsp";

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
        AjouterCommentaireForm form = new AjouterCommentaireForm();

        Commentaire commentaire = form.ajouterCommentaire( request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null ) {
            form.setErreur( "erreur", "noUserFound" );
            form.setResultat( "Aucun utilisateur connecté" );
        } else {
            form.setResultat( "Utilisateur connecté" );
        }

        commentaire.setCommentaires( connectedUser );

        commentaireService.addCommentaire( commentaire );

        session.setAttribute( ATT_SESSION_USER, connectedUser );

        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_COMMENTAIRE, commentaire );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
