package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDAO;
import com.aubrun.eric.projet6.model.bean.Utilisateur;
import com.aubrun.eric.projet6.webapp.forms.InscriptionForm;

@WebServlet( "/inscription" )
public class Inscription extends HttpServlet {

    private static final long   serialVersionUID = 1L;

    public static final String  ATT_USER         = "utilisateur";
    public static final String  ATT_FORM         = "form";
    public static final String  VUE              = "/WEB-INF/jsp/inscription.jsp";
    public final UtilisateurDAO utilisateurDAO   = new UtilisateurDAO();

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward(
                request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        /* Préparation de l'objet formulaire */
        InscriptionForm form = new InscriptionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.inscrireUtilisateur( request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        Utilisateur registredUser = utilisateurDAO.ajouterUtilisateur( utilisateur );
        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */

        session.setAttribute( ATT_USER, registredUser );

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        this.getServletContext().getRequestDispatcher( VUE ).forward(
                request, response );
    }
}