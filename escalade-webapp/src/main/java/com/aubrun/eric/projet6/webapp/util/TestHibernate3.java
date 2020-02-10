package com.aubrun.eric.projet6.webapp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestHibernate3 {

	private static final Object entity = null;

	public static void main(String[] args) {

		// Création de l'EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyUnitName");
		// Création de l'EntityManager
		EntityManager em = emf.createEntityManager();
		// Récupération d'une transaction
		EntityTransaction tx = em.getTransaction();

		// Début des modifications
		try {
			tx.begin();
			em.persist(entity);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			em.close();
			emf.close();
		}
	}
}
