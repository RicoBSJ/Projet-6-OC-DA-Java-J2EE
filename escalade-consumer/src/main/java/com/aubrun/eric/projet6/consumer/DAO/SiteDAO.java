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

    public List<Site> ajouterSite() {

        return null;
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
}