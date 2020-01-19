package com.aubrun.eric.projet6.consumer.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.aubrun.eric.projet6.model.bean.Site;

public class SiteDAO {
	private Connection connexion;

	public List<Site> recupererSites() {
		List<Site> utilisateurs = new ArrayList<Site>();
		Statement statement = null;
		ResultSet resultat = null;

		loadDatabase();

		try {
			statement = connexion.createStatement();

			// Exécution de la requête
			resultat = statement.executeQuery("SELECT nomSite FROM site;");

			// Récupération des données
			while (resultat.next()) {
				String nomSite = resultat.getString("nomSite");
//				String descripSite = resultat.getString("descripSite");
//				String cotationSite = resultat.getString("cotationSite");

				Site site = new Site();
				site.setNomSite(nomSite);
//				site.setDescripSite(descripSite);
//				site.setCotationSite(cotationSite);

				utilisateurs.add(site);
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

		return utilisateurs;
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

	public void ajouterSite(Site site) {
		loadDatabase();

		try {
			PreparedStatement preparedStatement = connexion
					.prepareStatement("INSERT INTO site(nomSite, descripSite, cotationSite) VALUES(?, ?, ?);");
			preparedStatement.setString(1, site.getNomSite());
//			preparedStatement.setString(2, site.getDescripSite());
//			preparedStatement.setString(3, site.getCotationSite());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}