package com.aubrun.eric.projet6.consumer.DAO;

import java.util.List;

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

    public List<Site> afficherDetails() {

        Session session = factory.getCurrentSession();
        List<Site> sites = null;

        try {
            String image = "";

            switch ( image ) {
            case "images/ablon_marc_daviet_crop_995x516.jpg":
                System.out.println( "Ouch !" );
                break;
            case "images/ailefroide_escalade_5__crop_995x516.jpg":
                System.out.println( "Vous avez juste la moyenne." );
                break;
            case "images/annot-fred-oddo-dans-6c__crop_995x516.jpg":
                System.out.println( "Parfait !" );
                break;
            case "images/antalya1_dr_crop_995x516.jpg":
                System.out.println( "Parfait !" );
                break;
            case "images/arudy_falaise__crop_995x516.jpg":
                System.out.println( "Parfait !" );
                break;
            default:
                System.out.println( "Il faut davantage travailler." );
            }

            return null;
        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return sites;
    }
}