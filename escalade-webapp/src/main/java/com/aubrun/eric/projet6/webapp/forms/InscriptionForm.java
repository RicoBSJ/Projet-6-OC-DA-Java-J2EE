package com.aubrun.eric.projet6.webapp.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import com.aubrun.eric.projet6.business.service.UtilisateurService;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public final class InscriptionForm {

    private static final String CHAMP_EMAIL      = "email";
    private static final String CHAMP_PASS       = "motdepasse";
    private static final String CHAMP_CONF       = "confirmation";
    private static final String CHAMP_NOM        = "nom";
    private static final String CHAMP_PRENOM     = "prenom";
    private static final String ALGO_CHIFFREMENT = "SHA-256";

    private String              resultat;
    private Map<String, String> erreurs          = new HashMap<String, String>();
    private UtilisateurService  utilisateurService;

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat( String result ) {
        this.resultat = result;
    }

    public Utilisateur inscrireUtilisateur( HttpServletRequest request ) {
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motdepasse = getValeurChamp( request, CHAMP_PASS );
        String confirmation = getValeurChamp( request, CHAMP_CONF );
        String nom = getValeurChamp( request, CHAMP_NOM );
        String prenom = getValeurChamp( request, CHAMP_PRENOM );

        Utilisateur utilisateur = new Utilisateur();
        try {
            traiterEmail( email, utilisateur );
            traiterMotsDePasse( motdepasse, confirmation, utilisateur );
            traiterNom( nom, utilisateur );
            traiterPrenom( prenom, utilisateur );
            resultat = "Inscription réussie !";
        } catch ( Exception e ) {
            resultat = "Echec de l'inscription : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        return utilisateur;
    }

    private void traiterEmail( String email, Utilisateur utilisateur ) {
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );
    }

    private void traiterMotsDePasse( String motdepasse, String confirmation, Utilisateur utilisateur ) {
        try {
            validationMotsDePasse( motdepasse, confirmation );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, null );
        }

        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
        passwordEncryptor.setPlainDigest( false );
        String motDePasseChiffre = passwordEncryptor.encryptPassword( motdepasse );

        utilisateur.setMotDePasse( motDePasseChiffre );
    }

    private void traiterNom( String nom, Utilisateur utilisateur ) {
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        utilisateur.setNom( nom );
    }

    private void traiterPrenom( String prenom, Utilisateur utilisateur ) {
        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        utilisateur.setPrenom( prenom );
    }

    private void validationEmail( String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            } else if ( utilisateurService.findByEmail( email ) != null ) {
                throw new Exception( "Cette adresse email est déjà  utilisée, merci d'en choisir une autre." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    private void validationMotsDePasse( String motdepasse, String confirmation ) throws Exception {
        if ( motdepasse != null && confirmation != null ) {
            if ( !motdepasse.equals( confirmation ) ) {
                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à  nouveau." );
            } else if ( motdepasse.length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }

    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
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