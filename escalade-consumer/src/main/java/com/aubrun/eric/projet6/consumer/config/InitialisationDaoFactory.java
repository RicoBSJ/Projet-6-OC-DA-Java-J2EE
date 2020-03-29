package com.aubrun.eric.projet6.consumer.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.aubrun.eric.projet6.consumer.factory.DAOFactory;

public class InitialisationDaoFactory implements ServletContextListener {

    /*
     * Récupération du ServletContext à la ligne 16 ; obtention d'une instance
     * de notre DAOFactory via un appel à sa méthode statique
     * DAOFactory.getInstance() ; Placement de cette instance dans un attribut
     * du ServletContext via sa méthode setAttribute(), qui a donc pour portée
     * l'application entière
     */

    private static final String ATT_DAO_FACTORY = "daofactory";

    private DAOFactory          daoFactory;

    @Override
    public void contextInitialized( ServletContextEvent event ) {
        /* Récupération du ServletContext lors du chargement de l'application */
        ServletContext servletContext = event.getServletContext();
        /* Instanciation de notre DAOFactory */
        this.daoFactory = DAOFactory.getInstance();
        /*
         * Enregistrement dans un attribut ayant pour portée toute l'application
         */
        servletContext.setAttribute( ATT_DAO_FACTORY, this.daoFactory );
    }

    @Override
    public void contextDestroyed( ServletContextEvent event ) {
        /* Rien à réaliser lors de la fermeture de l'application... */
    }
}
