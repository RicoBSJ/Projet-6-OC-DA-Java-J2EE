package com.aubrun.eric.projet6.webapp.filters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PrechargementFilter implements Filter {
    
    public static final String CONF_DAO_FACTORY      = "daofactory";
    public static final String ATT_SESSION_CLIENTS   = "clients";
    public static final String ATT_SESSION_COMMANDES = "commandes";

    private ClientDao          clientDao;
    private CommandeDao        commandeDao;

    public void init( FilterConfig config ) throws ServletException {
        /* Récupération d'une instance de nos DAO Client et Commande */
        this.clientDao = ( (DAOFactory) config.getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getClientDao();
        this.commandeDao = ( (DAOFactory) config.getServletContext().getAttribute( CONF_DAO_FACTORY ) )
                .getCommandeDao();
    }

    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException,
            ServletException {
        /* Cast de l'objet request */
        HttpServletRequest request = (HttpServletRequest) req;

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /*
         * Si la map des clients n'existe pas en session, alors l'utilisateur se
         * connecte pour la première fois et nous devons précharger en session
         * les infos contenues dans la BDD.
         */
        if ( session.getAttribute( ATT_SESSION_CLIENTS ) == null ) {
            /*
             * Récupération de la liste des clients existants, et enregistrement
             * en session
             */
            List<Client> listeClients = clientDao.lister();
            Map<Long, Client> mapClients = new HashMap<Long, Client>();
            for ( Client client : listeClients ) {
                mapClients.put( client.getId(), client );
            }
            session.setAttribute( ATT_SESSION_CLIENTS, mapClients );
        }

        /* Pour terminer, poursuite de la requête en cours */
        chain.doFilter( request, res );
    }

    public void destroy() {
    }
}

}
