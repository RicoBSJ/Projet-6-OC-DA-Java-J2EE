package com.aubrun.eric.projet6.model.bean;

public class Site {

	String nomSite;
	String descripSite;
	String cotationSite;
	String[] listeSecteur;
	String[] listeBloc;
	String commentaire;
	String nomPhoto;
	Integer numUtil;

	public String getNomSite() {
		return nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}

	public String getDescripSite() {
		return descripSite;
	}

	public void setDescripSite(String descriptSite) {
		this.descripSite = descriptSite;
	}

	public String getCotationSite() {
		return cotationSite;
	}

	public void setCotationSite(String cotationSite) {
		this.cotationSite = cotationSite;
	}

	public String[] getListeSecteur() {
		return listeSecteur;
	}

	public void setListeSecteur(String[] listeSecteur) {
		this.listeSecteur = listeSecteur;
	}

	public String[] getListeBloc() {
		return listeBloc;
	}

	public void setListeBloc(String[] listeBloc) {
		this.listeBloc = listeBloc;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	public Integer getNumUtil() {
		return numUtil;
	}

	public void setNumUtil(Integer numUtil) {
		this.numUtil = numUtil;
	}
}