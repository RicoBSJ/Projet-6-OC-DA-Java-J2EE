package com.aubrun.eric.projet6.business.service;

import java.util.List;

import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDAO;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class UtilisateurService {

    private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    public List<Utilisateur> findAll() {

        List<Utilisateur> utilisateur = utilisateurDAO.recupererUtilisateurs();
        for ( Utilisateur u : utilisateur ) {
            System.out.println( u );
        }
        return utilisateur;
    }

    public Utilisateur findById( Integer id ) {

        return utilisateurDAO.afficherParId( id );
    }

    public Utilisateur findByEmail( String email ) {

        return utilisateurDAO.afficherParEmail( email );
    }

    public Utilisateur register( Utilisateur utilisateur ) {

        return utilisateurDAO.ajouterUtilisateur( utilisateur );
    }

    public Utilisateur deleteUser( Integer id ) {

        return utilisateurDAO.supprimerUtilisateur( id );
    }

    public Utilisateur connexion( Utilisateur credential ) {

        Utilisateur connected = utilisateurDAO.afficherParEmail( credential.getEmail() );
        if ( connected == null ) {
            return null;
        }
        if ( !connected.getMotDePasse().equals( credential.getMotDePasse() ) ) {
            return null;
        }
        connected.setMotDePasse( null );
        return connected;
    }
}