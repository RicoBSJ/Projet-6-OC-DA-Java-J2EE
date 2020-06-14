package com.aubrun.eric.projet6.webapp.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.aubrun.eric.projet6.model.bean.Topo;

public final class ReserverTopoForm {

    private static final String CHAMP_NOM         = "nom";
    private static final String CHAMP_DESCRIPTION = "description";
    private static final String CHAMP_LIEU        = "lieu";

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

    public Topo reserverTopo( HttpServletRequest request ) {

        String nom = getValeurChamp( request, CHAMP_NOM );
        String description = getValeurChamp( request, CHAMP_DESCRIPTION );
        String lieu = getValeurChamp( request, CHAMP_LIEU );

        Topo topo = new Topo();
        try {
            traiterNom( nom, topo );
            traiterDescription( description, topo );
            traiterLieu( lieu, topo );
        } catch ( Exception e ) {
            resultat = "Echec de la réservation de topo : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        return topo;
    }

    private void traiterNom( String nom, Topo topo ) {
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        topo.setNom( nom );
    }

    private void traiterDescription( String description, Topo topo ) {
        try {
            validationDescription( description );
        } catch ( Exception e ) {
            setErreur( CHAMP_DESCRIPTION, e.getMessage() );
        }
        topo.setDescription( description );
    }

    private void traiterLieu( String lieu, Topo topo ) {
        try {
            validationLieu( lieu );
        } catch ( Exception e ) {
            setErreur( CHAMP_LIEU, e.getMessage() );
        }
        topo.setLieu( lieu );
    }

    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
            throw new Exception( "Le nom du topo doit contenir au moins 3 caractères." );
        }
    }

    private void validationDescription( String description ) throws Exception {
        if ( description != null && description.length() < 3 ) {
            throw new Exception( "La description du topo doit contenir au moins 3 caractères." );
        }
    }

    private void validationLieu( String lieu ) throws Exception {
        if ( lieu != null && lieu.length() < 3 ) {
            throw new Exception( "Le lieu du topo doit contenir au moins 3 caractères." );
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