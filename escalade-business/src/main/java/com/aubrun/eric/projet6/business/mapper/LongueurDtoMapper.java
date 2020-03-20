package com.aubrun.eric.projet6.business.mapper;

import com.aubrun.eric.projet6.business.dto.LongueurDto;
import com.aubrun.eric.projet6.model.bean.Longueur;

public class LongueurDtoMapper {

    static public LongueurDto toDto( Longueur longueur ) {

        LongueurDto dto = new LongueurDto();
        dto.setId( longueur.getId() );
        dto.setNom( longueur.getNom() );
        dto.setCotation( longueur.getCotation() );
        dto.setDescription( longueur.getDescription() );
        return dto;
    }

    static public Longueur toEntity( LongueurDto longueurDto ) {

        Longueur entity = new Longueur();
        entity.setId( longueurDto.getId() );
        entity.setNom( longueurDto.getNom() );
        entity.setCotation( longueurDto.getCotation() );
        entity.setDescription( longueurDto.getDescription() );
        return entity;
    }
}