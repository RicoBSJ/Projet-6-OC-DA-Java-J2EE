package com.aubrun.eric.projet6.webapp.forms;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.aubrun.eric.projet6.model.bean.Commentaire;

public class AjouterCommentaireForm {

    private static final String CHAMP_COMMENTAIRE = "commentaire";
    private static final String CHAMP_TITRE       = "titre";
    private static final Date   CHAMP_DATE        = "date";

    private String              resultat;
    private Map<String, String> erreurs           = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public void setResultat( String result ) {
        this.resultat = result;
    }

    public Commentaire ajouterCommentaire( HttpServletRequest request ) {
        String commentaire = getValeurChamp( request, CHAMP_COMMENTAIRE );
        String titre = getValeurChamp( request, CHAMP_TITRE );
        Date date = getValeurChamp( request, CHAMP_DATE );

        Commentaire comment = new Commentaire();
        try {
            traiterCommentaire( commentaire, comment );
            traiterTitre( titre, comment );
            traiterDate( date, comment );
            resultat = "Ajout du commentaire réussi !";
        } catch ( Exception e ) {
            resultat = "Echec de l'ajout de commentaire : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        return comment;
    }

    private void traiterCommentaire( String commentaire, Commentaire comment ) {
        try {
            validationCommentaire( commentaire );
        } catch ( Exception e ) {
            setErreur( CHAMP_COMMENTAIRE, e.getMessage() );
        }
        comment.setCommentaire( commentaire );
    }

    private void traiterTitre( String titre, Commentaire comment ) {
        try {
            validationTitre( titre );
        } catch ( Exception e ) {
            setErreur( CHAMP_COMMENTAIRE, e.getMessage() );
        }
        comment.setTitre( titre );
    }

    private void traiterDate( Date date, Commentaire comment ) {
        try {
            validationDate( date );
        } catch ( Exception e ) {
            setErreur( CHAMP_COMMENTAIRE, e.getMessage() );
        }
        comment.setDate( date );
    }

    private void validationCommentaire( String commentaire ) throws Exception {
        if ( commentaire != null && commentaire.length() < 30 ) {
            throw new Exception( "Le commentaire doit contenir au moins 30 caractères." );
        }
    }

    private void validationTitre( String titre ) throws Exception {
        if ( titre != null && titre.length() < 5 ) {
            throw new Exception( "Le titre doit contenir au moins 5 caractères." );
        }
    }

    private void validationDate( Date date ) throws Exception {
        if ( date != null ) {
            throw new Exception( "La date doit être renseignée." );
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

    private Date getValeurChamp( HttpServletRequest request, Date champDate ) {
        Date valeur = request.getParameter( champDate );
        if ( valeur == null ) {
            return null;
        } else {
            return valeur;
        }
    }
}