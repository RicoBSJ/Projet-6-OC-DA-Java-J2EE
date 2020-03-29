package com.aubrun.eric.projet6.business.mapper;

import com.aubrun.eric.projet6.business.dto.TopoDto;
import com.aubrun.eric.projet6.model.bean.Topo;

public class TopoDtoMapper {

    static public TopoDto toDto( Topo topo ) {

        TopoDto dto = new TopoDto();
        dto.setId( topo.getId() );
        dto.setNom( topo.getNom() );
        dto.setDescription( topo.getDescription() );
        return dto;
    }

    static public Topo toEntity( TopoDto topoDto ) {

        Topo entity = new Topo();
        entity.setId( topoDto.getId() );
        entity.setNom( topoDto.getNom() );
        entity.setDescription( topoDto.getDescription() );
        return entity;
    }
}
