package com.idrunk.controller.dtos;

import com.idrunk.models.Tafel;

public class TafelDto {

    public Long id;

    public Long tafelNr;

    public int maxGuest;

    public static TafelDto fromTafel(Tafel tafel) {
        var dto = new TafelDto();
        dto.id = tafel.getId();
        dto.tafelNr = tafel.getTafelNr();
        dto.maxGuest = tafel.getMaxGuest();
        return dto;
    }
}