package com.aubrun.eric.projet6.model.bean;

import java.util.Date;

public class Topo {

	String nomSite;
	String topo;
	String descriptTopo;
	String lieu;
	Date dateParution;
	Boolean reserve;
	String nomPhoto;

	public String getNomSite() {
		return nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}

	public String getTopo() {
		return topo;
	}

	public void setTopo(String topo) {
		this.topo = topo;
	}

	public String getDescriptTopo() {
		return descriptTopo;
	}

	public void setDescriptTopo(String descriptTopo) {
		this.descriptTopo = descriptTopo;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Date getDateParution() {
		return dateParution;
	}

	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}

	public Boolean getReserve() {
		return reserve;
	}

	public void setReserve(Boolean reserve) {
		this.reserve = reserve;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}
}