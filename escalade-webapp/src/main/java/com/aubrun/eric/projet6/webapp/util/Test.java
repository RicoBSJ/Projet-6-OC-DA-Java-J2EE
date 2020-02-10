package com.aubrun.eric.projet6.webapp.util;

import org.hibernate.Session;

import com.aubrun.eric.projet6.model.bean.Photo;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Photo user = new Photo();

		user.setId(1);
		user.setNomPhoto("Les Têtes Brulées");

		session.save(user);
		session.getTransaction().commit();

	}
}