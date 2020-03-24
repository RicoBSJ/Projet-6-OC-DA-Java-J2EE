package com.aubrun.eric.projet6.consumer.DAO;

import com.aubrun.eric.projet6.model.bean.Utilisateur;

public interface UtilisateurDao {

    void creer( Utilisateur utilisateur ) throws DAOException;

    Utilisateur trouver( String email ) throws DAOException;
}
