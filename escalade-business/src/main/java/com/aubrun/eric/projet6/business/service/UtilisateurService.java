package com.aubrun.eric.projet6.business.service;

import java.util.List;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDAO;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class UtilisateurService {

    private UtilisateurDAO      utilisateurDAO   = new UtilisateurDAO();
    private static final String ALGO_CHIFFREMENT = "SHA-256";

    public List<Utilisateur> findAll() {

        List<Utilisateur> utilisateur = utilisateurDAO.recupererUtilisateurs();
        return utilisateur;
    }

    public Utilisateur findById( Integer id ) {

        return utilisateurDAO.afficherParId( id );
    }

    public Utilisateur findByEmail( String email ) {

        return utilisateurDAO.afficherParEmail( email );
    }

    public Utilisateur deleteUser( Integer id ) {

        return utilisateurDAO.supprimerUtilisateur( id );
    }

    public Utilisateur connexion( Utilisateur credential ) {

        Utilisateur connected = utilisateurDAO.afficherParEmail( credential.getEmail() );
        if ( connected == null ) {
            return null;
        }
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
        passwordEncryptor.setPlainDigest( false );
        boolean passwordOk = passwordEncryptor.checkPassword( credential.getMotDePasse(), connected.getMotDePasse() );
        if ( !passwordOk ) {
            return null;
        }
        connected.setMotDePasse( null );
        return connected;
    }

    public void registration( Utilisateur registerUser ) {

        utilisateurDAO.ajouterUtilisateur( registerUser );
    }
}