package com.aubrun.eric.projet6.model.bean;

public class Reservation {

	String nomSite;
	Integer numReservation;
	Boolean topoDisponible;
	Integer numUtil;

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

	public Boolean isTopoDisponible() {
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