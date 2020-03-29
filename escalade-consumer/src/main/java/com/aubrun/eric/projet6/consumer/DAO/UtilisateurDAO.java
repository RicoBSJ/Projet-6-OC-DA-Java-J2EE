package com.aubrun.eric.projet6.consumer.DAO;

import static com.aubrun.eric.projet6.consumer.DAOUtilitaire.fermeturesSilencieuses;
import static com.aubrun.eric.projet6.consumer.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.consumer.exception.DAOException;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class UtilisateurDAO {

    private static final String SQL_SELECT        = "SELECT id, nom, prenom, adresse, telephone, email FROM Utilisateur ORDER BY id";
    private static final String SQL_SELECT_PAR_ID = "SELECT id, nom, prenom, adresse, telephone, email FROM Utilisateur WHERE id = ?";
    private static final String SQL_INSERT        = "INSERT INTO Utilisateur (nom, prenom, adresse, telephone, email) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Utilisateur WHERE id = ?";

    SessionFactory              factory           = HibernateUtils.getSessionFactory();

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */

    public Utilisateur trouver( int id ) throws DAOException {
        return trouver( SQL_SELECT_PAR_ID, id );
    }

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */

    public void creer( Utilisateur utilisateur ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true,
                    utilisateur.getNom(), utilisateur.getPrenom(),
                    utilisateur.getAdresse(), utilisateur.getTelephone(), utilisateur.getEmail() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création du utilisateur, aucune ligne ajoutée dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                utilisateur.setId( valeursAutoGenerees.getInt( 1 ) );
            } else {
                throw new DAOException( "Échec de la création du utilisateur en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */

    public void supprimer( Utilisateur utilisateur ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE_PAR_ID, true,
                    utilisateur.getId() );
            int statut = preparedStatement.executeUpdate();
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la suppression du utilisateur, aucune ligne supprimée de la table." );
            } else {
                utilisateur.setId( null );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion );
        }
    }

    /*
     * Méthode générique utilisée pour retourner un utilisateur depuis la base
     * de données, correspondant à la requête SQL donnée prenant en paramètres
     * les objets passés en argument.
     */
    private Utilisateur trouver( String sql, Object... objets ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            /*
             * Préparation de la requête avec les objets passés en arguments
             * (ici, uniquement un id) et exécution.
             */
            preparedStatement = initialisationRequetePreparee( connexion, sql, false, objets );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données retournée dans le ResultSet */
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

    public List<Utilisateur> listerUtilisateurs() {

        Session session = factory.getCurrentSession();
        List<Utilisateur> utilisateurs = null;

        try {
            session.getTransaction().begin();
            String q = "SELECT u FROM Utilisateur u";
            Query<Utilisateur> query = session.createQuery( q );
            utilisateurs = query.getResultList();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return utilisateurs;
    }

    public List<Utilisateur> creerUtilisateur() {

        return null;
    }

    public Utilisateur afficherDetailsUtilisateur( Integer id ) {

        Session session = factory.getCurrentSession();
        Utilisateur utilisateur = null;

        try {
            session.getTransaction().begin();
            String q = "SELECT u FROM Utilisateur u WHERE u.id=?1";
            TypedQuery<Utilisateur> query = session.createQuery( q, Utilisateur.class );
            query.setParameter( 1, id );
            utilisateur = query.getSingleResult();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return utilisateur;
    }
}
