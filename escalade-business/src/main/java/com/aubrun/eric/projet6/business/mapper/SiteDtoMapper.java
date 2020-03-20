package com.aubrun.eric.projet6.business.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.aubrun.eric.projet6.business.dto.PhotoDto;
import com.aubrun.eric.projet6.business.dto.SecteurDto;
import com.aubrun.eric.projet6.business.dto.SiteDto;
import com.aubrun.eric.projet6.model.bean.Site;

public class SiteDtoMapper {

    static public SiteDto toDto( Site site ) {

        SiteDto dto = new SiteDto();
        dto.setId( site.getId() );
        dto.setNom( site.getNom() );
        dto.setPays( site.getPays() );
        dto.setRegion( site.getRegion() );
        dto.setDescription( site.getDescription() );
        dto.setCotation( site.getCotation() );
        dto.setHauteur( site.getHauteur() );
        dto.setOrientation( site.getOrientation() );
        List<PhotoDto> photos = site.getPhotos().stream().map( PhotoDtoMapper::toDto )
                .collect( Collectors.toList() );
        dto.setPhotos( photos );
        List<SecteurDto> secteurs = site.getSecteurs().stream().map(
                SecteurDtoMapper::toDto )
                .collect( Collectors.toList() );
        dto.setSecteurs( secteurs );
        return dto;
    }

    static public Site toEntity( SiteDto siteDto ) {

        Site entity = new Site();
        entity.setId( siteDto.getId() );
        entity.setNom( siteDto.getNom() );
        entity.setPays( siteDto.getPays() );
        entity.setRegion( siteDto.getRegion() );
        entity.setDescription( siteDto.getDescription() );
        entity.setCotation( siteDto.getCotation() );
        entity.setHauteur( siteDto.getHauteur() );
        entity.setOrientation( siteDto.getOrientation() );
        return entity;
    }
}