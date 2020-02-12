package com.aubrun.eric.projet6.model.bean;

public class Longueur {

	Integer id;
	String nomLongueur;
	String cotationLongueur;
	String descriptLongueur;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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