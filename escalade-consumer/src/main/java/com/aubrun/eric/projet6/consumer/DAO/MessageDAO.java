package com.aubrun.eric.projet6.consumer.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.Message;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class MessageDAO {

    SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Message> recupererMessages() {

        Session session = factory.openSession();
        List<Message> messages = null;

        try {
            String q = "SELECT t FROM Message t";
            Query<Message> query = session.createQuery( q );
            messages = query.getResultList();

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return messages;
    }

    public List<Message> recupererMessagesUtilisateur( Utilisateur user ) {

        Session session = factory.openSession();
        List<Message> messages = null;

        try {
            String q = "SELECT t FROM Message t WHERE t.destinataire=?1";
            Query<Message> query = session.createQuery( q );
            query.setParameter( 1, user );
            messages = query.getResultList();

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return messages;
    }

    public Message afficherDetails( Integer id ) {

        Session session = factory.openSession();
        Message message = null;

        try {
            String q = "SELECT t FROM Message t WHERE t.id=?1";
            TypedQuery<Message> query = session.createQuery( q, Message.class );
            query.setParameter( 1, id );
            message = query.getSingleResult();

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return message;
    }

    public void supprimerMessage( Integer idMessage ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();

            Message message = session.get( Message.class, idMessage );
            if ( message != null ) {
                String q = "DELETE FROM Message t " + "WHERE t.id = :messageId";
                Query<Message> query = session.createQuery( q );
                query.setParameter( "messageId", idMessage );
                int result = query.executeUpdate();
                System.out.println( result );
            }

            session.getTransaction().commit();
        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void ajouterMessage( Message message ) {
        // TODO Auto-generated method stub
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.save( message );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void modifierMessage( Message message ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.update( message );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void reservationMessage( Message message ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.save( message );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void accepterDemande( Message message ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.save( message );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void refuserDemande( Message message ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.delete( message );
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