package com.aubrun.eric.projet6.business.service;

import java.util.ArrayList;
import java.util.List;

import com.aubrun.eric.projet6.business.dto.UtilisateurDto;
import com.aubrun.eric.projet6.business.mapper.UtilisateurDtoMapper;
import com.aubrun.eric.projet6.consumer.DAO.UtilisateurDAO;
import com.aubrun.eric.projet6.model.bean.Utilisateur;

public class UtilisateurService {

    private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    public List<UtilisateurDto> findAllUsers() {

        List<Utilisateur> utilisateur = utilisateurDAO.listerUtilisateurs();
        List<UtilisateurDto> dto = new ArrayList<UtilisateurDto>();
        for ( Utilisateur u : utilisateur ) {
            UtilisateurDto utilisateurDto = UtilisateurDtoMapper.toDto( u );
            dto.add( utilisateurDto );
        }
        return dto;
    }

    public List<Utilisateur> createUser() {

        return null;
    }

    public List<Utilisateur> deleteUser() {

        return null;
    }

    public UtilisateurDto findDetailsUser( Integer id ) {

        Utilisateur utilisateur = utilisateurDAO.afficherDetailsUtilisateur( id );
        return UtilisateurDtoMapper.toDto( utilisateur );
    }

}
