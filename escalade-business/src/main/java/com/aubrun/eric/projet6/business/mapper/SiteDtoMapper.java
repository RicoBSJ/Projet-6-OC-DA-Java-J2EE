package com.aubrun.eric.projet6.business.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.aubrun.eric.projet6.business.dto.PhotoDto;
import com.aubrun.eric.projet6.business.dto.SiteDto;
import com.aubrun.eric.projet6.model.bean.Site;

public class SiteDtoMapper {

    static public SiteDto toDto( Site site ) {

        SiteDto dto = new SiteDto();
        dto.setId( site.getId() );
        dto.setNomSite( site.getNomSite() );
        dto.setPays( site.getPays() );
        dto.setRegion( site.getRegion() );
        dto.setDescripSite( site.getDescripSite() );
        dto.setCotationSite( site.getCotationSite() );
        dto.setHauteur( site.getHauteur() );
        dto.setOrientation( site.getOrientation() );
        List<PhotoDto> photos = site.getPhotos().stream().map( PhotoDtoMapper::toDto )
                .collect( Collectors.toList() );
        dto.setPhotos( photos );
        // List<SecteurDto> secteurs = site.getSecteurs().stream().map(
        // SecteurDtoMapper::toDto )
        // .collect( Collectors.toList() );
        // dto.setSecteurs( secteurs );
        return dto;
    }

    static public Site toEntity( SiteDto siteDto ) {

        Site entity = new Site();
        entity.setId( siteDto.getId() );
        entity.setNomSite( siteDto.getNomSite() );
        entity.setPays( siteDto.getPays() );
        entity.setRegion( siteDto.getRegion() );
        entity.setDescripSite( siteDto.getDescripSite() );
        entity.setCotationSite( siteDto.getCotationSite() );
        entity.setHauteur( siteDto.getHauteur() );
        entity.setOrientation( siteDto.getOrientation() );
        return entity;
    }
}