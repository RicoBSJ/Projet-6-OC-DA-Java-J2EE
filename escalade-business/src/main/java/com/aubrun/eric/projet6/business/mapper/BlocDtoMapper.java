package com.aubrun.eric.projet6.business.mapper;

import com.aubrun.eric.projet6.business.dto.BlocDto;
import com.aubrun.eric.projet6.model.bean.Bloc;

public class BlocDtoMapper {

    static public BlocDto toDto( Bloc bloc ) {

        BlocDto dto = new BlocDto();
        dto.setId( bloc.getId() );
        dto.setNom( bloc.getNom() );
        dto.setDescription( bloc.getDescription() );
        return dto;
    }

    static public Bloc toEntity( BlocDto blocDto ) {

        Bloc entity = new Bloc();
        entity.setId( blocDto.getId() );
        entity.setNom( blocDto.getNom() );
        entity.setDescription( blocDto.getDescription() );
        return entity;
    }
}