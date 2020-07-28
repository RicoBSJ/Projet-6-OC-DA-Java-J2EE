package com.aubrun.eric.projet6.consumer.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.SearchFormSecteur;
import com.aubrun.eric.projet6.model.bean.Secteur;

public class SecteurDAO {

    SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Secteur> recherche( SearchFormSecteur searchFormSecteur ) {
        Session session = factory.getCurrentSession();
        List<Secteur> resultat = null;
        try {
            Map<String, String> parameters = new HashMap();
            session.getTransaction().begin();
            String q = "SELECT l FROM Longueur l WHERE 1=1 ";
            if ( searchFormSecteur.getNom() != "" ) {
                q += "AND s.nom LIKE :nom ";
                parameters.put( "nom", "%" + searchFormSecteur.getNom() + "%" );
            }
            if ( searchFormSecteur.getDescription() != "" ) {
                q += "AND s.description LIKE :description ";
                parameters.put( "description", "%" + searchFormSecteur.getDescription() + "%" );
            }
            Query<Secteur> query = session.createQuery( q );
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
}
