package com.aubrun.eric.projet6.business.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.aubrun.eric.projet6.business.dto.LongueurDto;
import com.aubrun.eric.projet6.business.dto.VoieDto;
import com.aubrun.eric.projet6.model.bean.Voie;

public class VoieDtoMapper {

    static public VoieDto toDto( Voie voie ) {

        VoieDto dto = new VoieDto();
        dto.setId( voie.getId() );
        dto.setNom( voie.getNom() );
        dto.setCotation( voie.getCotation() );
        dto.setDescription( voie.getDescription() );
        List<LongueurDto> longueurs = voie.getLongueurs().stream().map( LongueurDtoMapper::toDto )
                .collect( Collectors.toList() );
        dto.setLongueurs( longueurs );
        return dto;
    }

    static public Voie toEntity( VoieDto voieDto ) {

        Voie entity = new Voie();
        entity.setId( voieDto.getId() );
        entity.setNom( voieDto.getNom() );
        entity.setCotation( voieDto.getCotation() );
        entity.setDescription( voieDto.getDescription() );
        return entity;
    }

}
