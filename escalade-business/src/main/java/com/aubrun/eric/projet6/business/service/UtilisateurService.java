package com.aubrun.eric.projet6.business.service;

import java.util.ArrayList;
import java.util.List;

import com.aubrun.eric.projet6.business.dto.UtilisateurDto;
import com.aubrun.eric.projet6.business.mapper.UtilisateurDtoMapper;
import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDAO;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class UtilisateurService {

	private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

	public List<UtilisateurDto> findAll() {

		List<Utilisateur> utilisateur = utilisateurDAO.recupererUtilisateurs();
		List<UtilisateurDto> dto = new ArrayList<UtilisateurDto>();
		for (Utilisateur u : utilisateur) {
			UtilisateurDto utilisateurDto = UtilisateurDtoMapper.toDto(u);
			dto.add(utilisateurDto);
		}
		return dto;
	}

	public UtilisateurDto findById(Integer id) {

		Utilisateur utilisateur = utilisateurDAO.afficherParId(id);
		return UtilisateurDtoMapper.toDto(utilisateur);
	}

	public UtilisateurDto findByEmail(String email) {

		Utilisateur utilisateur = utilisateurDAO.afficherParEmail(email);
		return UtilisateurDtoMapper.toDto(utilisateur);
	}

	public UtilisateurDto createUser() {

		Utilisateur utilisateur = utilisateurDAO.ajouterUtilisateur();
		return null;
	}

	public UtilisateurDto deleteUser(Integer id) {

		Utilisateur utilisateur = utilisateurDAO.supprimerUtilisateur(id);
		return null;
	}
}