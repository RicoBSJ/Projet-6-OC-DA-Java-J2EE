package com.aubrun.eric.projet6.consumer.DAO;

import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {

    private DAOFactory daoFactory;

    UtilisateurDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    /*
     * Implémentation de la méthode trouver() définie dans l'interface
     * UtilisateurDao
     */
    @Override
    public Utilisateur trouver( String email ) throws DAOException {
        return null;
    }

    /*
     * Implémentation de la méthode creer() définie dans l'interface
     * UtilisateurDao
     */
    @Override
    public void creer( Utilisateur utilisateur ) throws IllegalArgumentException, DAOException {
    }
}
