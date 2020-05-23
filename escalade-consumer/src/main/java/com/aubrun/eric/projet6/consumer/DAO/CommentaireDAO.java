package com.aubrun.eric.projet6.consumer.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.Commentaire;
import com.aubrun.eric.projet6.model.bean.SearchFormCom;

public class CommentaireDAO {

    SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Commentaire> recupererCommentaires() {

        Session session = factory.getCurrentSession();
        List<Commentaire> commentaires = null;

        try {
            session.getTransaction().begin();
            String q = "SELECT c FROM Commentaire c";
            Query<Commentaire> query = session.createQuery( q );
            commentaires = query.getResultList();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return commentaires;
    }

    public Commentaire afficherDetails( Integer idCommentaire ) {

        Session session = factory.getCurrentSession();
        Commentaire commentaire = null;

        try {
            session.getTransaction().begin();
            String q = "SELECT c FROM Commentaire c WHERE c.idCommentaire=?1";
            TypedQuery<Commentaire> query = session.createQuery( q, Commentaire.class );
            query.setParameter( 1, idCommentaire );
            commentaire = query.getSingleResult();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return commentaire;
    }

    public void modifierCommentaire( Commentaire commentaire ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.update( commentaire );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }

    public void supprimerCommentaire( Integer idCommentaire ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();

            Commentaire commentaire = session.get( Commentaire.class, idCommentaire );
            if ( commentaire != null ) {
                session.getTransaction().begin();
                session.delete( idCommentaire );
                session.getTransaction().commit();
            }

            session.getTransaction().commit();
        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }

    public void ajouterCommentaire( Commentaire commentaire ) {
        // TODO Auto-generated method stub
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.save( commentaire );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }

    public List<Commentaire> recherche( SearchFormCom searchFormCom ) {
        Session session = factory.getCurrentSession();
        List<Commentaire> resultat = null;
        try {
            Map<String, String> parameters = new HashMap();
            session.getTransaction().begin();
            String q = "SELECT c FROM Commentaire c WHERE 1=1 ";
            if ( searchFormCom.getCommentaire() != "" ) {
                q += "AND c.commentaire LIKE :commentaire ";
                parameters.put( "commentaire", "%" + searchFormCom.getCommentaire() + "%" );
            }
            Query<Commentaire> query = session.createQuery( q );
            query.setProperties( parameters );
            resultat = query.getResultList();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return resultat;
    }
}