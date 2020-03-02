package com.aubrun.eric.projet6.business.mapper;

import com.aubrun.eric.projet6.business.dto.CommentaireDto;
import com.aubrun.eric.projet6.model.bean.Commentaire;

public class CommentaireDtoMapper {

    static public CommentaireDto toDto( Commentaire commentaire ) {

        CommentaireDto dto = new CommentaireDto();
        dto.setId( commentaire.getId() );
        dto.setCommentaire( commentaire.getCommentaire() );
        return dto;
    }

    static public Commentaire toEntity( CommentaireDto commentaireDto ) {

        Commentaire entity = new Commentaire();
        entity.setId( commentaireDto.getId() );
        entity.setCommentaire( commentaireDto.getCommentaire() );
        return entity;
    }
}