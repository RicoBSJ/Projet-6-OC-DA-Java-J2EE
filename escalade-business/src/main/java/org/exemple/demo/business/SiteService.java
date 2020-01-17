package org.exemple.demo.business;

import java.util.ArrayList;
import java.util.List;

import org.exemple.demo.business.dto.SiteDto;
import org.exemple.demo.business.dto.SiteDtoMapper;
import org.exemple.demo.model.bean.Site;

import com.octest.bdd.SiteDAO;

public class SiteService {

	private SiteDAO siteDAO = new SiteDAO();

	public List<SiteDto> findAll() {

		List<Site> site = siteDAO.recupererSites();
		List<SiteDto> dto = new ArrayList<SiteDto>();
		for (Site s : site) {
			SiteDto siteDto = SiteDtoMapper.toDto(s);
			dto.add(siteDto);
		}
		return dto;
	}

}
