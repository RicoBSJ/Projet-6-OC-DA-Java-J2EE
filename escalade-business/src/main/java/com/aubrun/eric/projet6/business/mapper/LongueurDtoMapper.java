package com.aubrun.eric.projet6.business.mapper;

import com.aubrun.eric.projet6.business.dto.LongueurDto;
import com.aubrun.eric.projet6.model.bean.Longueur;

public class LongueurDtoMapper {

    static public LongueurDto toDto( Longueur longueur ) {

        LongueurDto dto = new LongueurDto();
        dto.setId( longueur.getId() );
        dto.setNomLongueur( longueur.getNomLongueur() );
        dto.setCotationLongueur( longueur.getCotationLongueur() );
        dto.setDescriptLongueur( longueur.getDescriptLongueur() );
        return dto;
    }

    static public Longueur toEntity( LongueurDto longueurDto ) {

        Longueur entity = new Longueur();
        entity.setId( longueurDto.getId() );
        entity.setNomLongueur( longueurDto.getNomLongueur() );
        entity.setCotationLongueur( longueurDto.getCotationLongueur() );
        entity.setDescriptLongueur( longueurDto.getDescriptLongueur() );
        return entity;
    }

}
