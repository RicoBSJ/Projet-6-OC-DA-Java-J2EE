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
        for ( Utilisateur s : utilisateur ) {
            UtilisateurDto utilisateurDto = UtilisateurDtoMapper.toDto( s );
            dto.add( utilisateurDto );
        }
        return dto;
    }

    public UtilisateurDto findDetails( Integer id ) {

        Utilisateur utilisateur = utilisateurDAO.afficherDetails( id );
        return UtilisateurDtoMapper.toDto( utilisateur );
    }

    public UtilisateurDto addUtilisateur( Integer id ) {

        // Utilisateur utilisateur = utilisateurDAO.ajouterUtilisateur( id );
        return null;
    }

    public UtilisateurDto deleteUtilisateur( Integer id ) {

        // Utilisateur utilisateur = utilisateurDAO.supprimerUtilisateur( id );
        return null;
    }
}