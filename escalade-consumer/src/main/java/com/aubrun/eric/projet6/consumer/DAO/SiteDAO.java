package com.aubrun.eric.projet6.consumer.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.SearchModel;
import com.aubrun.eric.projet6.model.bean.Site;

public class SiteDAO {

    SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Site> recupererSites() {

        Session session = factory.openSession();
        List<Site> sites = null;

        try {
            String q = "SELECT s FROM Site s";
            Query<Site> query = session.createQuery( q );
            sites = query.getResultList();

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return sites;
    }

    public Site afficherDetails( Integer id ) {

        Session session = factory.openSession();
        Site site = null;

        try {
            String q = "SELECT s FROM Site s WHERE s.id=?1";
            TypedQuery<Site> query = session.createQuery( q, Site.class );
            query.setParameter( 1, id );
            site = query.getSingleResult();

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return site;
    }

    public void supprimerSite( Integer idSite ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            Site site = session.get( Site.class, idSite );
            if ( site != null ) {
                String q = "DELETE FROM Site s " + "WHERE s.id = :siteId";
                Query<Site> query = session.createQuery( q );
                query.setParameter( "siteId", idSite );
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

    public void ajouterSite( Site site ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.save( site );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public List<Site> recherche( SearchModel searchForm ) {
        Session session = factory.openSession();
        List<Site> resultat = null;
        try {
            Map<String, String> parameters = new HashMap();
            String q = "SELECT s FROM Site s WHERE 1=1 ";
            if ( searchForm.getNom() != "" ) {
                q += "AND s.nom LIKE :nom ";
                parameters.put( "nom", "%" + searchForm.getNom() + "%" );
            }
            if ( searchForm.getPays() != "" ) {
                q += "AND s.pays LIKE :pays ";
                parameters.put( "pays", "%" + searchForm.getPays() + "%" );
            }
            if ( searchForm.getRegion() != "" ) {
                q += "AND s.region LIKE :region ";
                parameters.put( "region", "%" + searchForm.getRegion() + "%" );
            }
            if ( searchForm.getDescription() != "" ) {
                q += "AND s.description LIKE :description ";
                parameters.put( "description", "%" + searchForm.getDescription() + "%" );
            }
            if ( searchForm.getCotation() != "" ) {
                q += "AND s.cotation LIKE :cotation ";
                parameters.put( "cotation", "%" + searchForm.getCotation() + "%" );
            }
            if ( searchForm.getHauteur() != "" ) {
                q += "AND s.hauteur LIKE :hauteur ";
                parameters.put( "hauteur", "%" + searchForm.getHauteur() + "%" );
            }
            if ( searchForm.getOrientation() != "" ) {
                q += "AND s.orientation LIKE :orientation ";
                parameters.put( "orientation", "%" + searchForm.getOrientation() + "%" );
            }
            if ( searchForm.getSecteurs() != "" ) {
                q += "AND s.secteurs LIKE :secteurs ";
                parameters.put( "secteurs", "%" + searchForm.getSecteurs() + "%" );
            }
            if ( searchForm.getVoies() != "" ) {
                q += "AND s.voies LIKE :voies ";
                parameters.put( "voies", "%" + searchForm.getVoies() + "%" );
            }
            if ( searchForm.getLongueurs() != "" ) {
                q += "AND s.longueurs LIKE :longueurs ";
                parameters.put( "longueurs", "%" + searchForm.getLongueurs() + "%" );
            }
            Query<Site> query = session.createQuery( q );
            query.setProperties( parameters );
            resultat = query.getResultList();

        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return resultat;
    }

    public void modifierSite( Site site ) {

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.saveOrUpdate( site );
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