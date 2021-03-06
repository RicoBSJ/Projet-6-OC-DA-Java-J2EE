package com.aubrun.eric.projet6.webapp.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.aubrun.eric.projet6.model.bean.Site;

public final class CreationSiteForm {

    private static final String CHAMP_NOM         = "nom";
    private static final String CHAMP_PAYS        = "pays";
    private static final String CHAMP_REGION      = "region";
    private static final String CHAMP_DESCRIPTION = "description";
    private static final String CHAMP_COTATION    = "cotation";
    private static final String CHAMP_HAUTEUR     = "hauteur";
    private static final String CHAMP_ORIENTATION = "orientation";
    private static final String CHAMP_SECTEUR     = "secteur";
    private static final String CHAMP_VOIE        = "voie";
    private static final String CHAMP_LONGUEUR    = "longueur";

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

    public Site creerSite( HttpServletRequest request ) {
        String nom = getValeurChamp( request, CHAMP_NOM );
        String pays = getValeurChamp( request, CHAMP_PAYS );
        String region = getValeurChamp( request, CHAMP_REGION );
        String description = getValeurChamp( request, CHAMP_DESCRIPTION );
        String cotation = getValeurChamp( request, CHAMP_COTATION );
        String hauteur = getValeurChamp( request, CHAMP_HAUTEUR );
        String orientation = getValeurChamp( request, CHAMP_ORIENTATION );
        String secteurs = getValeurChamp( request, CHAMP_SECTEUR );
        String voies = getValeurChamp( request, CHAMP_VOIE );
        String longueurs = getValeurChamp( request, CHAMP_LONGUEUR );

        Site site = new Site();
        try {
            traiterNom( nom, site );
            traiterPays( pays, site );
            traiterRegion( region, site );
            traiterDescription( description, site );
            traiterCotation( cotation, site );
            traiterHauteur( hauteur, site );
            traiterOrientation( orientation, site );
            traiterSecteurs( secteurs, site );
            traiterVoies( voies, site );
            traiterLongueurs( longueurs, site );
            resultat = "Création du site réussie !";
        } catch ( Exception e ) {
            resultat = "Echec de la création de site : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        return site;
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

    private void traiterSecteurs( String secteurs, Site site ) {
        try {
            validationSecteurs( secteurs );
        } catch ( Exception e ) {
            setErreur( CHAMP_SECTEUR, e.getMessage() );
        }
        site.setSecteurs( secteurs );
    }

    private void traiterVoies( String voies, Site site ) {
        try {
            validationVoies( voies );
        } catch ( Exception e ) {
            setErreur( CHAMP_VOIE, e.getMessage() );
        }
        site.setVoies( voies );
    }

    private void traiterLongueurs( String longueurs, Site site ) {
        try {
            validationLongueurs( longueurs );
        } catch ( Exception e ) {
            setErreur( CHAMP_LONGUEUR, e.getMessage() );
        }
        site.setLongueurs( longueurs );
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

    private void validationSecteurs( String secteurs ) throws Exception {
        if ( secteurs != null && secteurs.length() < 3 ) {
            throw new Exception( "Le secteur du site doit contenir au moins 3 caractères." );
        }
    }

    private void validationVoies( String voies ) throws Exception {
        if ( voies != null && voies.length() < 3 ) {
            throw new Exception( "La voie du site doit contenir au moins 3 caractères." );
        }
    }

    private void validationLongueurs( String longueurs ) throws Exception {
        if ( longueurs != null && longueurs.length() < 3 ) {
            throw new Exception( "L'orientation du site doit contenir au moins 3 caractères." );
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