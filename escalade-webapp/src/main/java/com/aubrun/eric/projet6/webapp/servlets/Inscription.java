package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aubrun.eric.projet6.business.service.UtilisateurService;
import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDAO;
import com.aubrun.eric.projet6.consumer.form.InscriptionForm;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

@WebServlet( "/inscription" )
public class Inscription extends HttpServlet {

    private static final long  serialVersionUID   = 1L;

    // public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String ATT_USER           = "utilisateur";
    public static final String ATT_FORM           = "form";
    public static final String VUE                = "/WEB-INF/jsp/inscription.jsp";

    private UtilisateurService utilisateurService = new UtilisateurService();
    private UtilisateurDAO     utilisateurDAO;
    //
    // public void init() throws ServletException {
    // /* Récupération d'une instance de notre DAO Utilisateur */
    // this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute(
    // CONF_DAO_FACTORY ) ).getUtilisateurDao();
    // }

    public Inscription() {
        super();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        // request.setAttribute( "utilisateurs", utilisateurService.createUser()
        // );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        InscriptionForm form = new InscriptionForm( utilisateurDAO );

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.inscrireUtilisateur( request );

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request,
                response );
    }
}
