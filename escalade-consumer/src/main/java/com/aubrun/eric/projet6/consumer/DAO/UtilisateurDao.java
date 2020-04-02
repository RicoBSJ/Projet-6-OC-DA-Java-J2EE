package com.aubrun.eric.projet6.consumer.DAO;

import java.util.List;

import com.aubrun.eric.projet6.consumer.exception.DAOException;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public interface UtilisateurDao {

    void creer( Utilisateur utilisateur ) throws DAOException;

    Utilisateur trouver( long id ) throws DAOException;

    Utilisateur trouver( String email ) throws DAOException;

    List<Utilisateur> lister() throws DAOException;

    void supprimer( Utilisateur utilisateur ) throws DAOException;
}