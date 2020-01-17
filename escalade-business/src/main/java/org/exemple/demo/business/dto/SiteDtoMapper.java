package org.exemple.demo.business.dto;

import org.exemple.demo.model.bean.Site;

public class SiteDtoMapper {

	static public SiteDto toDto(Site site) {

		SiteDto dto = new SiteDto();
		dto.setNomSite(site.getNomSite());
		return dto;

	}
}
