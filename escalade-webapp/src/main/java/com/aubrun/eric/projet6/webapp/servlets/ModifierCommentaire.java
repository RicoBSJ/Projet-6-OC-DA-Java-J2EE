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

@WebServlet( "/modifierCommentaire" )
public class ModifierCommentaire extends HttpServlet {

    private static final long  serialVersionUID   = 1L;

    public static final String ATT_COMMENTAIRE    = "commentaire";
    public static final String ATT_FORM           = "form";
    public static final String ATT_SESSION_USER   = "sessionUtilisateur";
    public static final String VUE                = "/WEB-INF/jsp/modifierCommentaire.jsp";

    private CommentaireService commentaireService = new CommentaireService();

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page d'inscription */
        Integer id = Integer.parseInt( request.getParameter( "id" ) );

        HttpSession session = request.getSession();

        Utilisateur utilisateur = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( utilisateur == null ) {
            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        }
        request.setAttribute( "commentaire", commentaireService.findDetails( id ) );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        Utilisateur connectedUser = (Utilisateur) session.getAttribute( ATT_SESSION_USER );

        if ( connectedUser == null || !connectedUser.getMembre() ) {

            response.setStatus( HttpServletResponse.SC_FORBIDDEN );
            throw new RuntimeException();
        }
        Integer idCommentaire = Integer.parseInt( request.getParameter( "id" ) );
        Commentaire commentaire = new Commentaire();
        commentaire.setTitre( request.getParameter( "titre" ) );
        commentaire.setContenu( request.getParameter( "contenu" ) );
        commentaire.setUtilisateur( connectedUser );
        commentaireService.modifyComment( idCommentaire, commentaire );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}