package com.aubrun.eric.projet6.consumer.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aubrun.eric.projet6.model.bean.Site;

public class SiteDAO {

	private Connection connexion;
	private List<Site> sites = new ArrayList<Site>();
	private Statement statement = null;
	private ResultSet resultat = null;

	public List<Site> recupererSites() {

		loadDatabase();

		try {
			statement = connexion.createStatement();

			// Exécution de la requête
			resultat = statement.executeQuery("SELECT nomSite FROM site;");

			// Récupération des données
			while (resultat.next()) {
				String nomSite = resultat.getString("nomSite");

				Site site = new Site();
				site.setNomSite(nomSite);

				sites.add(site);
			}
		} catch (SQLException e) {
		} finally {
			// Fermeture de la connexion
			try {
				if (resultat != null)
					resultat.close();
				if (statement != null)
					statement.close();
				if (connexion != null)
					connexion.close();
			} catch (SQLException ignore) {
			}
		}

		return sites;
	}

	private void loadDatabase() {
		// Chargement du driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		}

		try {
			connexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/javaee", "postgres", "postgres");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Site> ajouterSites() {

		loadDatabase();

		try {
			statement = connexion.createStatement();

			// Exécution de la requête
			resultat = statement.executeQuery("INSERT INTO site(nomSite) VALUES(?);");

			// Récupération des données
			while (resultat.next()) {

//				String nomSite = resultat.getString("nomSite");

				Site site = new Site();
				site.getNomSite();

				sites.add(site);
			}
		} catch (SQLException e) {
		} finally {
			// Fermeture de la connexion
			try {
				if (resultat != null)
					resultat.close();
				if (statement != null)
					statement.close();
				if (connexion != null)
					connexion.close();
			} catch (SQLException ignore) {
			}
		}
		return sites;
	}
}
//	public void ajouterSite(Site site) {
//		loadDatabase();
//
//		try {
//			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO site(nomSite) VALUES(?);");
//			preparedStatement.setString(1, site.getNomSite());
//
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}