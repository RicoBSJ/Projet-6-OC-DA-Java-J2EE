package com.aubrun.eric.projet6.consumer.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.Longueur;
import com.aubrun.eric.projet6.model.bean.SearchFormLongueur;

public class LongueurDAO {

    SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Longueur> rechercheLongueur( SearchFormLongueur searchFormLongueur ) {
        Session session = factory.getCurrentSession();
        List<Longueur> resultat = null;
        try {
            Map<String, String> parameters = new HashMap();
            session.getTransaction().begin();
            String q = "SELECT l FROM Longueur l WHERE 1=1 ";
            if ( searchFormLongueur.getNom() != "" ) {
                q += "AND s.nom LIKE :nom ";
                parameters.put( "nom", "%" + searchFormLongueur.getNom() + "%" );
            }
            if ( searchFormLongueur.getCotation() != "" ) {
                q += "AND s.cotation LIKE :cotation ";
                parameters.put( "cotation", "%" + searchFormLongueur.getCotation() + "%" );
            }
            if ( searchFormLongueur.getDescription() != "" ) {
                q += "AND s.description LIKE :description ";
                parameters.put( "description", "%" + searchFormLongueur.getDescription() + "%" );
            }
            Query<Longueur> query = session.createQuery( q );
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

    public void ajouterLongueur( Longueur lenght ) {
        // TODO Auto-generated method stub
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.save( lenght );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }
}