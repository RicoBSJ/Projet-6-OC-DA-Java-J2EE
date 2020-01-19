package com.aubrun.eric.projet6.model.bean;

public class Secteur {

	String nomSite;
	String nomSecteur;
	String descriptSecteur;
	String acces;
	String[] listeVoie;

	public String getNomSite() {
		return nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}

	public String getNomSecteur() {
		return nomSecteur;
	}

	public void setNomSecteur(String nomSecteur) {
		this.nomSecteur = nomSecteur;
	}

	public String getDescriptSecteur() {
		return descriptSecteur;
	}

	public void setDescriptSecteur(String descriptSecteur) {
		this.descriptSecteur = descriptSecteur;
	}

	public String getAcces() {
		return acces;
	}

	public void setAcces(String acces) {
		this.acces = acces;
	}

	public String[] getListeVoie() {
		return listeVoie;
	}

	public void setListeVoie(String[] listeVoie) {
		this.listeVoie = listeVoie;
	}
}