package com.aubrun.eric.projet6.consumer.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.aubrun.eric.projet6.consumer.HibernateUtils;
import com.aubrun.eric.projet6.model.bean.SearchForm;
import com.aubrun.eric.projet6.model.bean.Site;

public class SiteDAO {

	SessionFactory factory = HibernateUtils.getSessionFactory();

	public List<Site> recupererSites() {

		Session session = factory.getCurrentSession();
		List<Site> sites = null;

		try {
			session.getTransaction().begin();
			String q = "SELECT s FROM Site s";
			Query<Site> query = session.createQuery(q);
			sites = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return sites;
	}

	public Site afficherDetails(Integer id) {

		Session session = factory.getCurrentSession();
		Site site = null;

		try {
			session.getTransaction().begin();
			String q = "SELECT s FROM Site s WHERE s.id=?1";
			TypedQuery<Site> query = session.createQuery(q, Site.class);
			query.setParameter(1, id);
			site = query.getSingleResult();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return site;
	}

	public Site supprimerSite(int id) {

		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();

			Site site = session.get(Site.class, id);
			if (site != null) {
				String q = "DELETE FROM Site s " + "WHERE s.id = :siteId";
				Query<Site> query = session.createQuery(q);
				query.setParameter("siteId", id);
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

	public void ajouterSite(Site site) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();
			session.save(site);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
	}

	public List<Site> recherche(SearchForm searchForm) {
		Session session = factory.getCurrentSession();
		List<Site> resultat = null;
		try {
			Map<String, String> parameters = new HashMap();
			session.getTransaction().begin();
			String q = "SELECT s FROM Site s WHERE 1=1 ";
			if (searchForm.getNom() != "") {
				q += "AND s.nom LIKE :nom ";
				parameters.put("nom", "%" + searchForm.getNom() + "%");
			}
			if (searchForm.getPays() != "") {
				q += "AND s.pays LIKE :pays ";
				parameters.put("pays", "%" + searchForm.getPays() + "%");
			}
			if (searchForm.getRegion() != "") {
				q += "AND s.region LIKE :region ";
				parameters.put("region", "%" + searchForm.getRegion() + "%");
			}
			if (searchForm.getDescription() != "") {
				q += "AND s.description LIKE :description ";
				parameters.put("description", "%" + searchForm.getDescription() + "%");
			}
			if (searchForm.getCotation() != "") {
				q += "AND s.cotation LIKE :cotation ";
				parameters.put("cotation", "%" + searchForm.getCotation() + "%");
			}
			if (searchForm.getHauteur() != "") {
				q += "AND s.hauteur LIKE :hauteur ";
				parameters.put("hauteur", "%" + searchForm.getHauteur() + "%");
			}
			if (searchForm.getOrientation() != "") {
				q += "AND s.orientation LIKE :orientation ";
				parameters.put("orientation", "%" + searchForm.getOrientation() + "%");
			}
			Query<Site> query = session.createQuery(q);
			query.setProperties(parameters);
			resultat = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return resultat;
	}

	public Boolean taguerUnSiteOfficiel(Boolean taguer) {

		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();
			session.update(taguer);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return taguer;
	}
}