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

import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDAO;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

@WebServlet( "/suppressionUtilisateur" )
public class SuppressionUtilisateur extends HttpServlet {

    private static final long  serialVersionUID     = 1L;

    public static final String CONF_DAO_FACTORY     = "daofactory";
    public static final String PARAM_ID_UTILISATEUR = "idUtilisateur";
    public static final String SESSION_UTILISATEURS = "utilisateurs";

    public static final String VUE                  = "/listeUtilisateurs";

    private UtilisateurDAO     utilisateurDAO;

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        String idUtilisateur = getValeurParametre( request, PARAM_ID_UTILISATEUR );
        Integer id = Integer.parseInt( idUtilisateur );

        HttpSession session = request.getSession();
        Map<Integer, Utilisateur> utilisateurs = (HashMap<Integer, Utilisateur>) session
                .getAttribute( SESSION_UTILISATEURS );

        if ( id != null && utilisateurs != null ) {
            try {

                utilisateurDAO.supprimerUtilisateur( id );

                utilisateurs.remove( id );
            } catch ( Exception e ) {
                e.printStackTrace();
            }
            session.setAttribute( SESSION_UTILISATEURS, utilisateurs );
        }

        response.sendRedirect( request.getContextPath() + VUE );
    }

    private static String getValeurParametre( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}