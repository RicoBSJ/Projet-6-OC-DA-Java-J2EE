package com.aubrun.eric.projet6.webapp.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.aubrun.eric.projet6.consumer.DAO.DAOFactory;
import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDao;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class PrechargementFilter implements Filter {

    public static final String CONF_DAO_FACTORY         = "daofactory";
    public static final String ATT_SESSION_UTILISATEURS = "utilisateurs";
    public static final String ATT_SESSION_COMMANDES    = "commandes";

    private UtilisateurDao     utilisateurDao;

    public void init( FilterConfig config ) throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.utilisateurDao = ( (DAOFactory) config.getServletContext().getAttribute( CONF_DAO_FACTORY ) )
                .getUtilisateurDao();
    }

    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException,
            ServletException {
        /* Cast de l'objet request */
        HttpServletRequest request = (HttpServletRequest) req;

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /*
         * Si la map des utilisateurs n'existe pas en session, alors
         * l'utilisateur se connecte pour la première fois et nous devons
         * précharger en session les infos contenues dans la BDD.
         */
        if ( session.getAttribute( ATT_SESSION_UTILISATEURS ) == null ) {
            /*
             * Récupération de la liste des utilisateurs existants, et
             * enregistrement en session
             */
            List<Utilisateur> listeUtilisateurs = utilisateurDao.lister();
            Map<Integer, Utilisateur> mapUtilisateurs = new HashMap<Integer, Utilisateur>();
            for ( Utilisateur utilisateur : listeUtilisateurs ) {
                mapUtilisateurs.put( utilisateur.getId(), utilisateur );
            }
            session.setAttribute( ATT_SESSION_UTILISATEURS, mapUtilisateurs );
        }

        /* Pour terminer, poursuite de la requête en cours */
        chain.doFilter( request, res );
    }

    public void destroy() {
    }
}