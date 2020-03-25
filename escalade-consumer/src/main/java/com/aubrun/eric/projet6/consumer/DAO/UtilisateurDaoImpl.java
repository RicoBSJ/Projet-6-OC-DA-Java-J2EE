package com.aubrun.eric.projet6.consumer.DAO;

import static com.aubrun.eric.projet6.consumer.DAO.DAOUtilitaire.fermeturesSilencieuses;
import static com.aubrun.eric.projet6.consumer.DAO.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {

    private DAOFactory daoFactory;

    UtilisateurDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    /*
     * Obtention d'une connexion, préparation d'une requête de lecture,
     * exécution, puis récupération et analyse du ResultSet retourné, et enfin
     * fermeture des ressources mises en jeu
     */

    private static final String SQL_SELECT_PAR_EMAIL = "SELECT id, email, nom, motDePasse, dateInscription FROM Utilisateur WHERE email = ?";

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */
    @Override
    public Utilisateur trouver( String email ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_EMAIL, false, email );
            resultSet = preparedStatement.executeQuery();
            /*
             * Parcours de la ligne de données de l'éventuel ResulSet retourné
             */
            if ( resultSet.next() ) {
                utilisateur = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return utilisateur;
    }

    /*
     * Obtention d'une connexion, préparation d'une requête d'insertion avec
     * demande de renvoi de l'id auto-généré grâce au booléen à true passé à
     * notre méthode utilitaire DAOUtilitaire.initialisationRequetePreparee(),
     * exécution et récupération de son statut, récupération de l'id auto-généré
     * via l'appel à la méthode preparedStatement.getGeneratedKeys(), et enfin
     * fermeture des ressources mises en jeu.
     */

    private static final String SQL_INSERT = "INSERT INTO Utilisateur (email, motDePasse, nom, dateInscription) VALUES (?, ?, ?, NOW())";

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */
    @Override
    public void creer( Utilisateur utilisateur ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, utilisateur.getEmail(),
                    utilisateur.getMotDePasse(), utilisateur.getNom() );
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                /*
                 * Puis initialisation de la propriété id du bean Utilisateur
                 * avec sa valeur
                 */
                utilisateur.setId( valeursAutoGenerees.getInt( 1 ) );
            } else {
                throw new DAOException(
                        "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des utilisateurs (un
     * ResultSet) et un bean Utilisateur.
     */
    private static Utilisateur map( ResultSet resultSet ) throws SQLException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId( resultSet.getInt( "id" ) );
        utilisateur.setEmail( resultSet.getString( "email" ) );
        utilisateur.setMotDePasse( resultSet.getString( "mot_de_passe" ) );
        utilisateur.setNom( resultSet.getString( "nom" ) );
        utilisateur.setDateInscription( resultSet.getTimestamp( "date_inscription" ) );
        return utilisateur;
    }
}
