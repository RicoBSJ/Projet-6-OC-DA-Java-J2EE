package com.aubrun.eric.projet6.business.mapper;

import com.aubrun.eric.projet6.business.dto.PhotoDto;
import com.aubrun.eric.projet6.model.bean.Photo;

public class PhotoDtoMapper {

	static public PhotoDto toDto(Photo photo) {

		PhotoDto dto = new PhotoDto();
		dto.setId(photo.getId());
		dto.setNomPhoto(photo.getNomPhoto());
		dto.setUrl(photo.getUrl());
		return dto;
	}

	static public Photo toEntity(PhotoDto photoDto) {

		Photo entity = new Photo();
		entity.setId(photoDto.getId());
		entity.setNomPhoto(photoDto.getNomPhoto());
		entity.setUrl(photoDto.getUrl());
		return entity;
	}
}
