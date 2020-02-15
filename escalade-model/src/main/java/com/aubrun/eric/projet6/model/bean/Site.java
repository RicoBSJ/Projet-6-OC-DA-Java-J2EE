package com.aubrun.eric.projet6.model.bean;

public class Site {

	private Integer id;
	private String nomSite;
	private String descripSite;
	private String cotationSite;
	private String[] listeBloc;

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

	public String[] getListeBloc() {
		return listeBloc;
	}
}