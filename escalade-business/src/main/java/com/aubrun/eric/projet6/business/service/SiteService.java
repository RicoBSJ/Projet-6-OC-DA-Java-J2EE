package com.aubrun.eric.projet6.business.service;

import java.util.ArrayList;
import java.util.List;

import com.aubrun.eric.projet6.business.dto.SiteDto;
import com.aubrun.eric.projet6.business.mapper.SiteDtoMapper;
import com.aubrun.eric.projet6.consumer.DAO.SiteDAO;
import com.aubrun.eric.projet6.model.bean.Site;

public class SiteService {

    private SiteDAO siteDAO = new SiteDAO();

    public List<SiteDto> findAll() {

        List<Site> site = siteDAO.recupererSites();
        List<SiteDto> dto = new ArrayList<SiteDto>();
        for ( Site s : site ) {
            SiteDto siteDto = SiteDtoMapper.toDto( s );
            dto.add( siteDto );
        }
        return dto;
    }

    public SiteDto findDetails( Integer id ) {

        Site site = siteDAO.afficherDetails( id );
        return SiteDtoMapper.toDto( site );
    }
}
