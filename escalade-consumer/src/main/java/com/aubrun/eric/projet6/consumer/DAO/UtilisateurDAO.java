package com.aubrun.eric.projet6.consumer.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class UtilisateurDAO {

    SessionFactory factory = HibernateUtils.getSessionFactory();

    public Utilisateur inscrireUtilisateur() {

        Session session = factory.getCurrentSession();
        Utilisateur utilisateur = null;

        try {
            session.getTransaction().begin();
            String q = "INSERT u FROM Utilisateur u";
            Query<Utilisateur> query = session.createQuery( q );
            utilisateur = (Utilisateur) query.getResultList();
            session.getTransaction().commit();

        } catch ( Exception e ) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
        return utilisateur;
    }
}
