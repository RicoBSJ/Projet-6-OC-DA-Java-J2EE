package com.aubrun.eric.projet6.webapp.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.aubrun.eric.projet6.model.bean.Commentaire;

public class AjouterCommentaireForm {

    private static final String CHAMP_COMMENTAIRE = "commentaire";

    private String              resultat;
    private Map<String, String> erreurs           = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat( String result ) {
        this.resultat = result;
    }

    public Commentaire ajouterCommentaire( HttpServletRequest request ) {
        String comment = getValeurChamp( request, CHAMP_COMMENTAIRE );

        Commentaire commentaire = new Commentaire();
        try {
            traiterCommentaire( comment, commentaire );
            resultat = "Ajout du commentaire réussi !";
        } catch ( Exception e ) {
            resultat = "Echec de l'ajout de commentaire : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        return commentaire;
    }

    private void traiterCommentaire( String comment, Commentaire commentaire ) {
        try {
            validationCommentaire( comment );
        } catch ( Exception e ) {
            setErreur( CHAMP_COMMENTAIRE, e.getMessage() );
        }
        commentaire.setCommentaire( comment );
    }

    private void validationCommentaire( String commentaire ) throws Exception {
        if ( commentaire != null && commentaire.length() < 30 ) {
            throw new Exception( "Le commentaire doit contenir au moins 30 caractères." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    public void setErreur( String champ, String message ) {
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