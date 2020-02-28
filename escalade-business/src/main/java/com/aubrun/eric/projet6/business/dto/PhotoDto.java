package com.aubrun.eric.projet6.business.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class PhotoDto {

	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "nom")
	private String nomPhoto;
	@Column(name = "chemin")
	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
