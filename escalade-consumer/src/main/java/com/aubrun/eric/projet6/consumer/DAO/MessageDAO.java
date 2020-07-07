package com.aubrun.eric.projet6.consumer.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.Message;
import com.aubrun.eric.projet6.model.bean.SearchFormMessage;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class MessageDAO {

    SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Message> recupererMessages() {

        Session session = factory.getCurrentSession();
        List<Message> messages = null;

        try {
            session.getTransaction().begin();
            String q = "SELECT t FROM Message t";
            Query<Message> query = session.createQuery( q );
            messages = query.getResultList();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return messages;
    }

    public List<Message> recupererMessagesDeLUtilisateur( Utilisateur utilisateur ) {

        Session session = factory.getCurrentSession();
        List<Message> messages = null;

        try {
            session.getTransaction().begin();
            String q = "SELECT t FROM Message t WHERE t.utilisateur=?1";
            Query<Message> query = session.createQuery( q );
            query.setParameter( 1, utilisateur );
            messages = query.getResultList();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return messages;
    }

    public List<Message> recupererMessagesDisponibles() {

        Session session = factory.getCurrentSession();
        List<Message> messages = null;

        try {
            session.getTransaction().begin();
            String q = "SELECT t FROM Message t WHERE t.disponible=true";
            Query<Message> query = session.createQuery( q );
            messages = query.getResultList();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return messages;
    }

    public Message afficherDetails( Integer id ) {

        Session session = factory.getCurrentSession();
        Message message = null;

        try {
            session.getTransaction().begin();
            String q = "SELECT t FROM Message t WHERE t.id=?1";
            TypedQuery<Message> query = session.createQuery( q, Message.class );
            query.setParameter( 1, id );
            message = query.getSingleResult();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
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
        }
    }

    public List<Message> recherche( SearchFormMessage searchFormMessage ) {
        Session session = factory.getCurrentSession();
        List<Message> resultat = null;
        try {
            Map<String, String> parameters = new HashMap();
            session.getTransaction().begin();
            String q = "SELECT t FROM Message t WHERE 1=1 ";

            if ( searchFormMessage.getMessage() != "" ) {
                q += "AND t.message LIKE :message ";
                parameters.put( "message", "%" + searchFormMessage.getMessage() + "%" );
            }
            Query<Message> query = session.createQuery( q );
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
        }
    }

    public void reserverMessage( Message message ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.merge( message );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }
}