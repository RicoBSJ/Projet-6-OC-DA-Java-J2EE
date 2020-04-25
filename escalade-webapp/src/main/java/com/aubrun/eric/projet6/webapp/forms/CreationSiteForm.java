package com.aubrun.eric.projet6.webapp.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.aubrun.eric.projet6.model.bean.Photo;
import com.aubrun.eric.projet6.model.bean.Site;

public final class CreationSiteForm {

    private static final String CHAMP_NOM          = "nom";
    private static final String CHAMP_PAYS         = "pays";
    private static final String CHAMP_REGION       = "region";
    private static final String CHAMP_DESCRIPTION  = "description";
    private static final String CHAMP_COTATION     = "cotation";
    private static final String CHAMP_HAUTEUR      = "hauteur";
    private static final String CHAMP_ORIENTATION  = "orientation";
    private static final String CHAMP_CHEMIN_PHOTO = "cheminPhoto";

    private String              resultat;
    private Map<String, String> erreurs            = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat( String result ) {
        this.resultat = result;
    }

    public Site creerSite( HttpServletRequest request ) {
        String nom = getValeurChamp( request, CHAMP_NOM );
        String pays = getValeurChamp( request, CHAMP_PAYS );
        String region = getValeurChamp( request, CHAMP_REGION );
        String description = getValeurChamp( request, CHAMP_DESCRIPTION );
        String cotation = getValeurChamp( request, CHAMP_COTATION );
        String hauteur = getValeurChamp( request, CHAMP_HAUTEUR );
        String orientation = getValeurChamp( request, CHAMP_ORIENTATION );

        Site site = new Site();
        try {
            traiterNom( nom, site );
            traiterPays( pays, site );
            traiterRegion( region, site );
            traiterDescription( description, site );
            traiterCotation( cotation, site );
            traiterHauteur( hauteur, site );
            traiterOrientation( orientation, site );
            resultat = "Création du site réussie !";
        } catch ( Exception e ) {
            resultat = "Echec de la création de site : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        return site;
    }

    public Photo ajouterPhoto( HttpServletRequest request ) {

        String cheminPhoto = getValeurChamp( request, CHAMP_CHEMIN_PHOTO );

        Photo photo = new Photo();
        try {
            traiterCheminPhoto( cheminPhoto, photo );
            resultat = "Ajout photo réussi !";
        } catch ( Exception e ) {
            resultat = "Echec de l'ajout de photo : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        return photo;
    }

    private void traiterNom( String nom, Site site ) {
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        site.setNom( nom );
    }

    private void traiterPays( String pays, Site site ) {
        try {
            validationPays( pays );
        } catch ( Exception e ) {
            setErreur( CHAMP_PAYS, e.getMessage() );
        }
        site.setPays( pays );
    }

    private void traiterRegion( String region, Site site ) {
        try {
            validationRegion( region );
        } catch ( Exception e ) {
            setErreur( CHAMP_REGION, e.getMessage() );
        }
        site.setRegion( region );
    }

    private void traiterDescription( String description, Site site ) {
        try {
            validationDescription( description );
        } catch ( Exception e ) {
            setErreur( CHAMP_DESCRIPTION, e.getMessage() );
        }
        site.setDescription( description );
    }

    private void traiterCotation( String cotation, Site site ) {
        try {
            validationCotation( cotation );
        } catch ( Exception e ) {
            setErreur( CHAMP_COTATION, e.getMessage() );
        }
        site.setCotation( cotation );
    }

    private void traiterHauteur( String hauteur, Site site ) {
        try {
            validationHauteur( hauteur );
        } catch ( Exception e ) {
            setErreur( CHAMP_HAUTEUR, e.getMessage() );
        }
        site.setHauteur( hauteur );
    }

    private void traiterOrientation( String orientation, Site site ) {
        try {
            validationOrientation( orientation );
        } catch ( Exception e ) {
            setErreur( CHAMP_ORIENTATION, e.getMessage() );
        }
        site.setOrientation( orientation );
    }

    private void traiterCheminPhoto( String cheminPhoto, Photo photo ) {
        try {
            validationCheminPhoto( cheminPhoto );
        } catch ( Exception e ) {
            setErreur( CHAMP_ORIENTATION, e.getMessage() );
        }
        photo.setCheminPhoto( cheminPhoto );
    }

    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
            throw new Exception( "Le nom du site doit contenir au moins 3 caractères." );
        }
    }

    private void validationPays( String pays ) throws Exception {
        if ( pays != null && pays.length() < 3 ) {
            throw new Exception( "Le pays du site doit contenir au moins 3 caractères." );
        }
    }

    private void validationRegion( String region ) throws Exception {
        if ( region != null && region.length() < 3 ) {
            throw new Exception( "La région du site doit contenir au moins 3 caractères." );
        }
    }

    private void validationDescription( String description ) throws Exception {
        if ( description != null && description.length() < 3 ) {
            throw new Exception( "La description du site doit contenir au moins 3 caractères." );
        }
    }

    private void validationCotation( String cotation ) throws Exception {
        if ( cotation != null && cotation.length() < 3 ) {
            throw new Exception( "La cotation du site doit contenir au moins 3 caractères." );
        }
    }

    private void validationHauteur( String hauteur ) throws Exception {
        if ( hauteur != null && hauteur.length() < 3 ) {
            throw new Exception( "La hauteur du site doit contenir au moins 3 caractères." );
        }
    }

    private void validationOrientation( String orientation ) throws Exception {
        if ( orientation != null && orientation.length() < 3 ) {
            throw new Exception( "L'orientation du site doit contenir au moins 3 caractères." );
        }
    }

    private void validationCheminPhoto( String cheminPhoto ) throws Exception {
        if ( cheminPhoto != null && cheminPhoto.length() < 3 ) {
            throw new Exception( "Le chemin de la photo du site doit contenir au moins 3 caractères." );
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