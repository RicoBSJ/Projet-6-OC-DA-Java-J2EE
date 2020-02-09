package com.aubrun.eric.projet6.model.bean;

public class Reservation {

	Integer id;
	String nomSite;
	Integer numReservation;
	Boolean topoDisponible;
	Integer numUtil;

	public Reservation() {

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

	public Integer getNumReservation() {
		return numReservation;
	}

	public void setNumReservation(Integer numReservation) {
		this.numReservation = numReservation;
	}

	public Boolean getTopoDisponible() {
		return topoDisponible;
	}

	public void setTopoDisponible(Boolean topoDisponible) {
		this.topoDisponible = topoDisponible;
	}

	public Integer getNumUtil() {
		return numUtil;
	}

	public void setNumUtil(Integer numUtil) {
		this.numUtil = numUtil;
	}
}