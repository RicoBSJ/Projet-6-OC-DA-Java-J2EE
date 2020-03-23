package com.aubrun.eric.projet6.business.mapper;

import com.aubrun.eric.projet6.business.dto.UtilisateurDto;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class UtilisateurDtoMapper {

	static public UtilisateurDto toDto(Utilisateur utilisateur) {

		UtilisateurDto dto = new UtilisateurDto();
		dto.setId(utilisateur.getId());
		dto.setNom(utilisateur.getNom());
		dto.setPrenom(utilisateur.getPrenom());
		dto.setAdresse(utilisateur.getAdresse());
		dto.setTelephone(utilisateur.getTelephone());
		dto.setEmail(utilisateur.getEmail());
		dto.setMotDePasse(utilisateur.getMotDePasse());
		dto.setDateInscription(utilisateur.getDateInscription());
		return dto;
	}

	static public Utilisateur toEntity(UtilisateurDto utilisateurDto) {

		Utilisateur entity = new Utilisateur();
		entity.setId(utilisateurDto.getId());
		entity.setNom(utilisateurDto.getNom());
		entity.setPrenom(utilisateurDto.getPrenom());
		entity.setAdresse(utilisateurDto.getAdresse());
		entity.setTelephone(utilisateurDto.getTelephone());
		entity.setEmail(utilisateurDto.getEmail());
		entity.setMotDePasse(utilisateurDto.getMotDePasse());
		entity.setDateInscription(utilisateurDto.getDateInscription());
		return entity;
	}
}