package com.aubrun.eric.projet6.consumer.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class UtilisateurDAO {

    private static final String SQL_SELECT_PAR_ID = "SELECT id, nom, prenom, adresse, telephone, email FROM Utilisateur WHERE id = ?";
    private static final String SQL_INSERT        = "INSERT INTO Utilisateur (nom, prenom, adresse, telephone, email) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Utilisateur WHERE id = ?";

    SessionFactory              factory           = HibernateUtils.getSessionFactory();

    // public Utilisateur trouver( String sql, Object... objets ) throws
    // Exception {
    //
    // Session session = factory.getCurrentSession();
    // Utilisateur utilisateur = null;
    //
    // try {
    // /* Récupération d'une connexion depuis la Factory */
    // connexion = daoFactory.getConnection();
    // /*
    // * Préparation de la requête avec les objets passés en arguments
    // * (ici, uniquement un id) et exécution.
    // */
    // preparedStatement = initialisationRequetePreparee( connexion, sql, false,
    // objets );
    // resultSet = preparedStatement.executeQuery();
    // /* Parcours de la ligne de données retournée dans le ResultSet */
    // if ( resultSet.next() ) {
    // utilisateur = map( resultSet );
    // }
    // } catch ( SQLException e ) {
    // throw new Exception( e );
    // }
    // return utilisateur;
    // }

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

    // public void creer( Utilisateur utilisateur ) throws Exception {
    //
    // Connection connexion = null;
    // PreparedStatement preparedStatement = null;
    // Session session = factory.getCurrentSession();
    // List<Utilisateur> utilisateurs = null;
    //
    // try {
    // session.getTransaction().begin();
    // String q = "SELECT u FROM Utilisateur u";
    // preparedStatement = initialisationRequetePreparee( connexion,
    // SQL_INSERT, true, utilisateur.getNom(),
    // utilisateur.getPrenom(), utilisateur.getAdresse(),
    // utilisateur.getTelephone(),
    // utilisateur.getEmail() );
    // int statut = preparedStatement.executeUpdate();
    // if ( statut == 0 ) {
    // throw new Exception( "Échec de la création du utilisateur, aucune ligne
    // ajoutée dans la table." );
    // }
    // valeursAutoGenerees = preparedStatement.getGeneratedKeys();
    // if ( valeursAutoGenerees.next() ) {
    // utilisateur.setId( valeursAutoGenerees.getInt( 1 ) );
    // } else {
    // throw new Exception( "Échec de la création du utilisateur en base, aucun
    // ID auto-généré retourné." );
    // }
    // } catch ( SQLException e ) {
    // throw new Exception( e );
    // }
    // }

    // public void supprimer( Utilisateur utilisateur ) throws Exception {
    //
    // Connection connexion = null;
    // PreparedStatement preparedStatement = null;
    // Session session = factory.getCurrentSession();
    // List<Utilisateur> utilisateurs = null;
    //
    // try {
    // session.getTransaction().begin();
    // String q = "SELECT u FROM Utilisateur u";
    // preparedStatement = initialisationRequetePreparee( connexion,
    // SQL_DELETE_PAR_ID, true,
    // utilisateur.getId() );
    // int statut = preparedStatement.executeUpdate();
    // if ( statut == 0 ) {
    // throw new Exception( "Échec de la suppression du utilisateur, aucune
    // ligne supprimée de la table." );
    // } else {
    // utilisateur.setId( null );
    // }
    // } catch ( SQLException e ) {
    // throw new Exception( e );
    // }
    // }

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

    public Utilisateur supprimerUtilisateur() {

        return null;
    }

    public Utilisateur creerUtilisateur() {

        return null;
    }

    public Utilisateur trouverUtilisateur( int id ) {

        return null;
    }

    // public Utilisateur trouver( int id ) throws Exception {
    // return trouver( SQL_SELECT_PAR_ID, id );
    // }
}