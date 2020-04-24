package com.aubrun.eric.projet6.consumer.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.Photo;

public class PhotoDAO {

	SessionFactory factory = HibernateUtils.getSessionFactory();

	public List<Photo> recupererPhotos() {

		Session session = factory.getCurrentSession();
		List<Photo> photos = null;

		try {
			session.getTransaction().begin();
			String q = "SELECT p FROM Photo p";
			Query<Photo> query = session.createQuery(q);
			photos = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return photos;
	}

	public Photo afficherDetails(Integer id) {

		Session session = factory.getCurrentSession();
		Photo photo = null;

		try {
			session.getTransaction().begin();
			String q = "SELECT p FROM Photo p WHERE p.id=?1";
			TypedQuery<Photo> query = session.createQuery(q, Photo.class);
			query.setParameter(1, id);
			photo = query.getSingleResult();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return photo;
	}

	public Photo supprimerPhoto(int id) {

		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();

			Photo photo = session.get(Photo.class, id);
			if (photo != null) {
				String q = "DELETE FROM Photo p " + "WHERE p.id = :photoId";
				Query<Photo> query = session.createQuery(q);
				query.setParameter("photoId", id);
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

	public void ajouterPhoto(Photo photo) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();
			session.save(photo);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
	}
}
