package com.aubrun.eric.projet6.webapp.util;

import org.hibernate.Session;

import com.aubrun.eric.projet6.model.bean.Photo;

public class TestHibernate2 {

	public static void main(String args[]) throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Photo user1 = (Photo) session.load(Photo.class, new Integer(1));
			System.out.println("nom = " + user1.getId() + "\ncréé par = " + user1.getNomPhoto());
			Photo user2 = (Photo) session.load(Photo.class, new Integer(2));
			System.out.println("nom = " + user2.getId() + "\ncréé par = " + user2.getNomPhoto());
		} finally {
			session.close();
		}
	}
}