package com.aubrun.eric.projet6.business.mapper;

import com.aubrun.eric.projet6.business.dto.ReservationDto;
import com.aubrun.eric.projet6.model.bean.Reservation;

public class ReservationDtoMapper {

    static public ReservationDto toDto( Reservation reservation ) {

        ReservationDto dto = new ReservationDto();
        dto.setId( reservation.getId() );
        dto.setNumero( reservation.getNumero() );
        return dto;
    }

    static public Reservation toEntity( ReservationDto reservationDto ) {

        Reservation entity = new Reservation();
        entity.setId( reservationDto.getId() );
        entity.setNumero( reservationDto.getNumero() );
        return entity;
    }
}
