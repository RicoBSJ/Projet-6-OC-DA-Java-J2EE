package com.aubrun.eric.projet6.consumer.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.Site;

public class SiteDAO {

    SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Site> recupererSites() {

        Session session = factory.getCurrentSession();
        List<Site> sites = null;

        try {
            session.getTransaction().begin();
            String q = "SELECT s FROM Site s";
            Query<Site> query = session.createQuery( q );
            sites = query.getResultList();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return sites;
    }

    public Site afficherDetails( Integer id ) {

        Session session = factory.getCurrentSession();
        Site site = null;

        try {
            session.getTransaction().begin();
            String q = "SELECT s FROM Site s WHERE s.id=?1";
            TypedQuery<Site> query = session.createQuery( q, Site.class );
            query.setParameter( 1, id );
            site = query.getSingleResult();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return site;
    }

    public Site supprimerSite( int id ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();

            Site site = session.get( Site.class, id );
            if ( site != null ) {
                String q = "DELETE FROM Site s " + "WHERE s.id = :siteId";
                Query<Site> query = session.createQuery( q );
                query.setParameter( "siteId", id );
                int result = query.executeUpdate();
                System.out.println( result );
            }

            session.getTransaction().commit();
        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return null;
    }

    public Site ajouterSite() {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            String q = "INSERT INTO Site s (nom, prenom, adresse, telephone, email)" +
                    "SELECT nom, prenom, adresse, telephone, email FROM Site s";
            Query<Site> query = session.createQuery( q );
            int result = query.executeUpdate();
            System.out.println( result );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return null;
    }
}