package com.aubrun.eric.projet6.webapp.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aubrun.eric.projet6.model.bean.Photo;

public class TestHibernate1 {

	public static void main(String args[]) throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Photo user = new Photo();

			user.setId(2);
			user.setNomPhoto("Les Gazelles");

			session.save(user);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}
}