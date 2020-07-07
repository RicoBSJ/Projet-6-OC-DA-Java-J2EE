package com.aubrun.eric.projet6.webapp.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.aubrun.eric.projet6.model.bean.Message;

public final class MessageDeReservationForm {

    private static final String CHAMP_NOM = "message";

    private String              resultat;
    private Map<String, String> erreurs   = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat( String result ) {
        this.resultat = result;
    }

    public Message messageReservation( HttpServletRequest request ) {

        String nom = getValeurChamp( request, CHAMP_NOM );

        Message message = new Message();
        try {
            traiterNom( nom, message );
        } catch ( Exception e ) {
            resultat = "Echec de la réservation de message : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        return message;
    }

    private void traiterNom( String nom, Message message ) {
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        message.setMessage( nom );
    }

    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
            throw new Exception( "Le nom du message doit contenir au moins 3 caractères." );
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