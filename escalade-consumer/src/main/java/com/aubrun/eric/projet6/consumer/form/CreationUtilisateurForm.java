package com.aubrun.eric.projet6.consumer.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDao;
import com.aubrun.eric.projet6.consumer.exception.DAOException;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public final class CreationUtilisateurForm {
    private static final String CHAMP_NOM       = "nomUtilisateur";
    private static final String CHAMP_PRENOM    = "prenomUtilisateur";
    private static final String CHAMP_ADRESSE   = "adresseUtilisateur";
    private static final String CHAMP_TELEPHONE = "telephoneUtilisateur";
    private static final String CHAMP_EMAIL     = "emailUtilisateur";

    private String              resultat;
    private Map<String, String> erreurs         = new HashMap<String, String>();
    private UtilisateurDao      utilisateurDao;

    public CreationUtilisateurForm( UtilisateurDao utilisateurDao ) {
        this.utilisateurDao = utilisateurDao;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public Utilisateur creerUtilisateur( HttpServletRequest request, String chemin ) {
        String nom = getValeurChamp( request, CHAMP_NOM );
        String prenom = getValeurChamp( request, CHAMP_PRENOM );
        String adresse = getValeurChamp( request, CHAMP_ADRESSE );
        String telephone = getValeurChamp( request, CHAMP_TELEPHONE );
        String email = getValeurChamp( request, CHAMP_EMAIL );

        Utilisateur utilisateur = new Utilisateur();

        traiterNom( nom, utilisateur );
        traiterPrenom( prenom, utilisateur );
        traiterAdresse( adresse, utilisateur );
        traiterTelephone( telephone, utilisateur );
        traiterEmail( email, utilisateur );

        try {
            if ( erreurs.isEmpty() ) {
                utilisateurDao.creer( utilisateur );
                resultat = "Succès de la création du utilisateur.";
            } else {
                resultat = "Échec de la création du utilisateur.";
            }
        } catch ( DAOException e ) {
            setErreur( "imprévu", "Erreur imprévue lors de la création." );
            resultat = "Échec de la création du utilisateur : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }

        return utilisateur;
    }

    private void traiterNom( String nom, Utilisateur utilisateur ) {
        try {
            validationNom( nom );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        utilisateur.setNom( nom );
    }

    private void traiterPrenom( String prenom, Utilisateur utilisateur ) {
        try {
            validationPrenom( prenom );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        utilisateur.setPrenom( prenom );
    }

    private void traiterAdresse( String adresse, Utilisateur utilisateur ) {
        try {
            validationAdresse( adresse );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_ADRESSE, e.getMessage() );
        }
        utilisateur.setAdresse( adresse );
    }

    private void traiterTelephone( String telephone, Utilisateur utilisateur ) {
        try {
            validationTelephone( telephone );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_TELEPHONE, e.getMessage() );
        }
        utilisateur.setTelephone( telephone );
    }

    private void traiterEmail( String email, Utilisateur utilisateur ) {
        try {
            validationEmail( email );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );
    }

    private void validationNom( String nom ) throws FormValidationException {
        if ( nom != null ) {
            if ( nom.length() < 2 ) {
                throw new FormValidationException( "Le nom d'utilisateur doit contenir au moins 2 caractères." );
            }
        } else {
            throw new FormValidationException( "Merci d'entrer un nom d'utilisateur." );
        }
    }

    private void validationPrenom( String prenom ) throws FormValidationException {
        if ( prenom != null && prenom.length() < 2 ) {
            throw new FormValidationException( "Le prénom d'utilisateur doit contenir au moins 2 caractères." );
        }
    }

    private void validationAdresse( String adresse ) throws FormValidationException {
        if ( adresse != null ) {
            if ( adresse.length() < 10 ) {
                throw new FormValidationException( "L'adresse de livraison doit contenir au moins 10 caractères." );
            }
        } else {
            throw new FormValidationException( "Merci d'entrer une adresse de livraison." );
        }
    }

    private void validationTelephone( String telephone ) throws FormValidationException {
        if ( telephone != null ) {
            if ( !telephone.matches( "^\\d+$" ) ) {
                throw new FormValidationException( "Le numéro de téléphone doit uniquement contenir des chiffres." );
            } else if ( telephone.length() < 4 ) {
                throw new FormValidationException( "Le numéro de téléphone doit contenir au moins 4 chiffres." );
            }
        } else {
            throw new FormValidationException( "Merci d'entrer un numéro de téléphone." );
        }
    }

    private void validationEmail( String email ) throws FormValidationException {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new FormValidationException( "Merci de saisir une adresse mail valide." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}