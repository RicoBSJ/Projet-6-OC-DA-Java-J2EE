package com.aubrun.eric.projet6.consumer.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.Commentaire;

public class CommentaireDAO {

    SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Commentaire> recupererCommentaires() {

        Session session = factory.openSession();
        List<Commentaire> commentaires = null;

        try {
            String q = "SELECT c FROM Commentaire c";
            Query<Commentaire> query = session.createQuery( q );
            commentaires = query.getResultList();

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return commentaires;
    }

    public Commentaire afficherDetails( Integer idCommentaire ) {

        Session session = factory.openSession();
        Commentaire commentaire = null;

        try {
            String q = "SELECT c FROM Commentaire c WHERE c.idCommentaire=?1";
            TypedQuery<Commentaire> query = session.createQuery( q, Commentaire.class );
            query.setParameter( 1, idCommentaire );
            commentaire = query.getSingleResult();

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            session.close();
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
        } finally {
            session.close();
        }
    }

    public void supprimerCommentaire( Commentaire commentaire ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.delete( commentaire );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void ajouterCommentaire( Commentaire commentaire ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.save( commentaire );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}