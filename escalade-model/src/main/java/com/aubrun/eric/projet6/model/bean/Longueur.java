package com.aubrun.eric.projet6.model.bean;

public class Longueur {

	Integer id;
	String nomSite;
	String nomLongueur;
	String cotationLongueur;
	String descriptLongueur;

	public Longueur() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomSite() {
		return nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}

	public String getNomLongueur() {
		return nomLongueur;
	}

	public void setNomLongueur(String nomLongueur) {
		this.nomLongueur = nomLongueur;
	}

	public String getCotationLongueur() {
		return cotationLongueur;
	}

	public void setCotationLongueur(String cotationLongueur) {
		this.cotationLongueur = cotationLongueur;
	}

	public String getDescriptLongueur() {
		return descriptLongueur;
	}

	public void setDescriptLongueur(String descriptLongueur) {
		this.descriptLongueur = descriptLongueur;
	}
}