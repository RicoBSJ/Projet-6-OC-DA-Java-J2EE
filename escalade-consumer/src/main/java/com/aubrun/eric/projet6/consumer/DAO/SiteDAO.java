package com.aubrun.eric.projet6.consumer.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.Site;

public class SiteDAO {

    private static final String SQL_SELECT_BY_ID  = "SELECT s FROM Site s WHERE s.id=?1";
    private static final String SQL_SELECT        = "SELECT s FROM Site s";
    private static final String SQL_INSERT        = "INSERT INTO Site s (nom, prenom, adresse, telephone, email)";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM Utilisateur WHERE id = ?";

    SessionFactory              factory           = HibernateUtils.getSessionFactory();

    public List<Site> recupererSites() {

        Session session = factory.getCurrentSession();
        List<Site> sites = null;

        try {
            session.getTransaction().begin();
            String q = SQL_SELECT;
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
            String q = SQL_SELECT_BY_ID;
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

    public Site supprimerSite( Integer id ) {

        Session session = factory.getCurrentSession();
        Site site = null;

        try {
            session.getTransaction().begin();
            String q = SQL_DELETE_PAR_ID;
            Query<Site> query = session.createQuery( q );
            query.setParameter( "id", id );
            int result = query.executeUpdate();
            site = query.getSingleResult();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return site;
    }

    public Site ajouterSite( Integer id ) {

        Session session = factory.getCurrentSession();
        Site site = null;

        try {
            session.getTransaction().begin();
            String q = SQL_INSERT;
            Query<Site> query = session.createQuery( q );
            int result = query.executeUpdate();
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