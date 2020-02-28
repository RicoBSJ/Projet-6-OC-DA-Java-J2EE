package com.aubrun.eric.projet6.business.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.aubrun.eric.projet6.model.bean.Photo;

@Entity
@Table
public class SiteDto {

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "nom")
	private String nomSite;
	@Column(name = "pays")
	private String pays;
	@Column(name = "region")
	private String region;
	@Column(name = "description")
	private String descripSite;
	@Column(name = "cotation")
	private String cotationSite;
	@Column(name = "hauteur")
	private Double hauteur;
	@Column(name = "orientation")
	private String orientation;
	@OneToMany
	@JoinColumn(name = "id_site")
	private List<Photo> photos;

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

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDescripSite() {
		return descripSite;
	}

	public void setDescripSite(String descripSite) {
		this.descripSite = descripSite;
	}

	public String getCotationSite() {
		return cotationSite;
	}

	public void setCotationSite(String cotationSite) {
		this.cotationSite = cotationSite;
	}

	public Double getHauteur() {
		return hauteur;
	}

	public void setHauteur(Double hauteur) {
		this.hauteur = hauteur;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
}
