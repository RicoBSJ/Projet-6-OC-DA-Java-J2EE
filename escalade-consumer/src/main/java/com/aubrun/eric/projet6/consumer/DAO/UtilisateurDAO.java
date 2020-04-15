package com.aubrun.eric.projet6.consumer.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class UtilisateurDAO {

	SessionFactory factory = HibernateUtils.getSessionFactory();

	public List<Utilisateur> recupererUtilisateurs() {

		Session session = factory.getCurrentSession();
		List<Utilisateur> utilisateurs = null;

		try {
			session.getTransaction().begin();
			String q = "SELECT u FROM Utilisateur u";
			Query<Utilisateur> query = session.createQuery(q);
			utilisateurs = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return utilisateurs;
	}

	public Utilisateur afficherParId(Integer id) {

		Session session = factory.getCurrentSession();
		Utilisateur utilisateur = null;

		try {
			session.getTransaction().begin();
			String q = "SELECT u FROM Utilisateur u WHERE u.id=?1";
			TypedQuery<Utilisateur> query = session.createQuery(q, Utilisateur.class);
			query.setParameter(1, id);
			utilisateur = query.getSingleResult();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return utilisateur;
	}

	public Utilisateur afficherParEmail(String email) {

		Session session = factory.getCurrentSession();
		Utilisateur utilisateur = null;

		try {
			session.getTransaction().begin();
			String q = "SELECT u FROM Utilisateur u WHERE u.email=?1";
			TypedQuery<Utilisateur> query = session.createQuery(q, Utilisateur.class);
			query.setParameter(1, email);
			utilisateur = query.getSingleResult();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return utilisateur;
	}

	public Utilisateur supprimerUtilisateur(int id) {

		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();

			Utilisateur utilisateur = session.get(Utilisateur.class, id);
			if (utilisateur != null) {
				String q = "DELETE FROM Utilisateur u " + "WHERE u.id = :utilisateurId";
				Query<Utilisateur> query = session.createQuery(q);
				query.setParameter("utilisateurId", id);
				int result = query.executeUpdate();
				System.out.println(result);
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return null;
	}

	public void ajouterUtilisateur(Utilisateur utilisateur) {

		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();
			String q = "INSERT INTO Utilisateur (nom, prenom, adresse, telephone, email)"
					+ "SELECT nom, prenom, adresse, telephone, email FROM Utilisateur";
			Query<Utilisateur> query = session.createQuery(q);
			int result = query.executeUpdate();
			System.out.println(result);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
	}
}