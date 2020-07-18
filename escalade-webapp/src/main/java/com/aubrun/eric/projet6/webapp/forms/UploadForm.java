package com.aubrun.eric.projet6.webapp.forms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.aubrun.eric.projet6.model.bean.Photo;

public final class UploadForm {
    private static final String CHAMP_DESCRIPTION = "description";
    private static final String CHAMP_FICHIER     = "fichier";
    public static final String  CHEMIN_FICHIERS   = "/Users/ricobsj/fichiers/";
    private static final int    TAILLE_TAMPON     = 10240;                        // 10
                                                                                  // ko
    private String              resultat;
    private Map<String, String> erreurs           = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Photo enregistrerFichier( HttpServletRequest request, String chemin ) {
        /* Initialisation du bean représentant un fichier */
        Photo photo = new Photo();

        /* Récupération du champ de description du formulaire */
        String description = request.getParameter( CHAMP_DESCRIPTION );
        request.setAttribute( CHAMP_DESCRIPTION, description );

        try {
            Part part = request.getPart( CHAMP_FICHIER );

            String nomFichier = getNomFichier( part );

            if ( nomFichier != null && !nomFichier.isEmpty() ) {

                String nomChamp = part.getName();

                nomFichier = nomFichier.substring( nomFichier.lastIndexOf( '/' ) + 1 )
                        .substring( nomFichier.lastIndexOf( '\\' ) + 1 );

                ecrireFichier( part, nomFichier, CHEMIN_FICHIERS );

                request.setAttribute( nomChamp, nomFichier );

            }
        } catch ( IllegalStateException e ) {
            /*
             * Exception retournée si la taille des données dépasse les limites
             * définies dans la section <multipart-config> de la déclaration de
             * notre servlet d'upload dans le fichier web.xml
             */
            e.printStackTrace();
            setErreur( CHAMP_FICHIER, "Les données envoyées sont trop volumineuses." );
        } catch ( IOException e ) {
            /*
             * Exception retournée si une erreur au niveau des répertoires de
             * stockage survient (répertoire inexistant, droits d'accès
             * insuffisants, etc.)
             */
            e.printStackTrace();
            setErreur( CHAMP_FICHIER, "Erreur de configuration du serveur." );
        } catch ( ServletException e ) {
            /*
             * Exception retournée si la requête n'est pas de type
             * multipart/form-data. Cela ne peut arriver que si l'utilisateur
             * essaie de contacter la servlet d'upload par un formulaire
             * différent de celui qu'on lui propose... pirate ! :|
             */
            e.printStackTrace();
            setErreur( CHAMP_FICHIER,
                    "Ce type de requête n'est pas supporté, merci d'utiliser le formulaire prévu pour envoyer votre fichier." );
        }

        return photo;
    }

    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    private static String getNomFichier( Part part ) {

        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }

    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream( part.getInputStream(), TAILLE_TAMPON );
            sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin + nomFichier ) ), TAILLE_TAMPON );

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ( ( longueur = entree.read( tampon ) ) > 0 ) {
                sortie.write( tampon, 0, longueur );
            }
        } finally {
            try {
                sortie.close();
            } catch ( IOException ignore ) {
            }
            try {
                entree.close();
            } catch ( IOException ignore ) {
            }
        }
    }
}