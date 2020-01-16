package org.exemple.demo.model.bean;

public class Voie {

	String nomSite;
	String nomVoie;
	String cotationVoie;
	String descriptVoie;
	String[] listeLongueur;
	Boolean voieEquipee;

	public String getNomSite() {
		return nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}

	public String getNomVoie() {
		return nomVoie;
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public String getCotationVoie() {
		return cotationVoie;
	}

	public void setCotationVoie(String cotationVoie) {
		this.cotationVoie = cotationVoie;
	}

	public String getDescriptVoie() {
		return descriptVoie;
	}

	public void setDescriptVoie(String descriptVoie) {
		this.descriptVoie = descriptVoie;
	}

	public String[] getListeLongueur() {
		return listeLongueur;
	}

	public void setListeLongueur(String[] listeLongueur) {
		this.listeLongueur = listeLongueur;
	}

	public Boolean getVoieEquipee() {
		return voieEquipee;
	}

	public void setVoieEquipee(Boolean voieEquipee) {
		this.voieEquipee = voieEquipee;
	}
}