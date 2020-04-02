package com.aubrun.eric.projet6.webapp.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDao;
import com.aubrun.eric.projet6.consumer.exception.DAOException;
import com.aubrun.eric.projet6.consumer.factory.DAOFactory;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

@WebServlet( "/suppressionUtilisateur" )
public class SuppressionUtilisateur extends HttpServlet {

    private static final long  serialVersionUID     = 1L;

    public static final String CONF_DAO_FACTORY     = "daofactory";
    public static final String PARAM_ID_UTILISATEUR = "idUtilisateur";
    public static final String SESSION_UTILISATEURS = "utilisateurs";

    public static final String VUE                  = "/listeUtilisateurs";

    private UtilisateurDao     utilisateurDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Récupération du paramètre */
        String idUtilisateur = getValeurParametre( request, PARAM_ID_UTILISATEUR );
        Integer id = (int) Long.parseLong( idUtilisateur );

        /* Récupération de la Map des utilisateurs enregistrés en session */
        HttpSession session = request.getSession();
        Map<Integer, Utilisateur> utilisateurs = (HashMap<Integer, Utilisateur>) session
                .getAttribute( SESSION_UTILISATEURS );

        /*
         * Si l'id du utilisateur et la Map des utilisateurs ne sont pas vides
         */
        if ( id != null && utilisateurs != null ) {
            try {
                /* Alors suppression du utilisateur de la BDD */
                utilisateurDao.supprimer( utilisateurs.get( id ) );
                /* Puis suppression du utilisateur de la Map */
                utilisateurs.remove( id );
            } catch ( DAOException e ) {
                e.printStackTrace();
            }
            /* Et remplacement de l'ancienne Map en session par la nouvelle */
            session.setAttribute( SESSION_UTILISATEURS, utilisateurs );
        }

        /* Redirection vers la fiche récapitulative */
        response.sendRedirect( request.getContextPath() + VUE );
    }

    /*
     * Méthode utilitaire qui retourne null si un paramètre est vide, et son
     * contenu sinon.
     */
    private static String getValeurParametre( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}