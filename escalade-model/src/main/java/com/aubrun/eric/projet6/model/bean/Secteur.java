package com.aubrun.eric.projet6.model.bean;

public class Secteur {

	Integer id;
	String nomSecteur;
	String descriptSecteur;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
}