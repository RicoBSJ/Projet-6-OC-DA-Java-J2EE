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

@WebServlet( "/ajouterCommentaire" )
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

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        }

        Commentaire commentaire = new Commentaire();
        commentaire.setUtilisateur( connectedUser );
        commentaire.setDate( new Date() );
        commentaireService.addCommentaire( commentaire );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}