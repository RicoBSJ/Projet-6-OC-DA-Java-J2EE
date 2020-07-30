package com.aubrun.eric.projet6.consumer.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.SearchFormVoie;
import com.aubrun.eric.projet6.model.bean.Voie;

public class VoieDAO {

    SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Voie> rechercheVoie( SearchFormVoie searchFormVoie ) {
        Session session = factory.getCurrentSession();
        List<Voie> resultat = null;
        try {
            Map<String, String> parameters = new HashMap();
            session.getTransaction().begin();
            String q = "SELECT l FROM Longueur l WHERE 1=1 ";
            if ( searchFormVoie.getNom() != "" ) {
                q += "AND s.nom LIKE :nom ";
                parameters.put( "nom", "%" + searchFormVoie.getNom() + "%" );
            }
            if ( searchFormVoie.getCotation() != "" ) {
                q += "AND s.cotation LIKE :cotation ";
                parameters.put( "cotation", "%" + searchFormVoie.getCotation() + "%" );
            }
            if ( searchFormVoie.getDescription() != "" ) {
                q += "AND s.description LIKE :description ";
                parameters.put( "description", "%" + searchFormVoie.getDescription() + "%" );
            }
            Query<Voie> query = session.createQuery( q );
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

    public void ajouterVoie( Voie way ) {
        // TODO Auto-generated method stub
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.save( way );
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }
}