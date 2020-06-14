package com.aubrun.eric.projet6.consumer.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.SearchFormTopo;
import com.aubrun.eric.projet6.model.bean.Topo;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class TopoDAO {

    SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Topo> recupererTopos() {

        Session session = factory.getCurrentSession();
        List<Topo> topos = null;

        try {
            session.getTransaction().begin();
            String q = "SELECT t FROM Topo t";
            Query<Topo> query = session.createQuery( q );
            topos = query.getResultList();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return topos;
    }

    public List<Topo> recupererToposDeLUtilisateur( Utilisateur utilisateur ) {

        Session session = factory.getCurrentSession();
        List<Topo> topos = null;

        try {
            session.getTransaction().begin();
            String q = "SELECT t FROM Topo t WHERE t.utilisateur=?1";
            Query<Topo> query = session.createQuery( q );
            query.setParameter( 1, utilisateur );
            topos = query.getResultList();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return topos;
    }

    public Topo afficherDetails( Integer id ) {

        Session session = factory.getCurrentSession();
        Topo topo = null;

        try {
            session.getTransaction().begin();
            String q = "SELECT t FROM Topo t WHERE t.id=?1";
            TypedQuery<Topo> query = session.createQuery( q, Topo.class );
            query.setParameter( 1, id );
            topo = query.getSingleResult();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return topo;
    }

    public void supprimerTopo( Integer idTopo ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();

            Topo topo = session.get( Topo.class, idTopo );
            if ( topo != null ) {
                String q = "DELETE FROM Topo t " + "WHERE t.id = :topoId";
                Query<Topo> query = session.createQuery( q );
                query.setParameter( "topoId", idTopo );
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

    public void ajouterTopo( Topo topo ) {
        // TODO Auto-generated method stub
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.save( topo );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }

    public List<Topo> recherche( SearchFormTopo searchFormTopo ) {
        Session session = factory.getCurrentSession();
        List<Topo> resultat = null;
        try {
            Map<String, String> parameters = new HashMap();
            session.getTransaction().begin();
            String q = "SELECT t FROM Topo t WHERE 1=1 ";
            if ( searchFormTopo.getNom() != "" ) {
                q += "AND t.nom LIKE :nom ";
                parameters.put( "nom", "%" + searchFormTopo.getNom() + "%" );
            }
            if ( searchFormTopo.getDescription() != "" ) {
                q += "AND t.description LIKE :description ";
                parameters.put( "description", "%" + searchFormTopo.getDescription() + "%" );
            }
            if ( searchFormTopo.getLieu() != "" ) {
                q += "AND t.cotation LIKE :lieu ";
                parameters.put( "lieu", "%" + searchFormTopo.getLieu() + "%" );
            }
            if ( searchFormTopo.getDateParution() != "" ) {
                q += "AND t.dateParution LIKE :dateParution ";
                parameters.put( "dateParution", "%" + searchFormTopo.getDateParution() + "%" );
            }
            Query<Topo> query = session.createQuery( q );
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

    public void modifierTopo( Topo topo ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.update( topo );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }

    public void reserverTopo( Topo topo ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.update( topo );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }
}