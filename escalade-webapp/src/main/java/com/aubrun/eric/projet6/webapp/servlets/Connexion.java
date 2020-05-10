package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.business.service.UtilisateurService;
import com.aubrun.eric.projet6.model.bean.Utilisateur;
import com.aubrun.eric.projet6.webapp.forms.ConnexionForm;

@WebServlet( "/Connexion" )
public class Connexion extends HttpServlet {

    private static final long       serialVersionUID   = 1L;

    public static final String      ATT_FORM           = "form";
    public static final String      ATT_SESSION_USER   = "sessionUtilisateur";
    public static final String      VUE                = "/WEB-INF/jsp/connexion.jsp";
    public final UtilisateurService utilisateurService = new UtilisateurService();

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.connecterUtilisateur( request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        Utilisateur connectedUser = utilisateurService.connexion( utilisateur );

        if ( connectedUser == null ) {
            form.setErreur( "erreur", "noUserFound" );
            form.setResultat( "Cet utilisateur n'existe pas ou ce mot de passe est incorrect" );
        } else {
            form.setResultat( "La connexion a réussi" );
        }

        session.setAttribute( ATT_SESSION_USER, connectedUser );

        request.setAttribute( ATT_FORM, form );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}