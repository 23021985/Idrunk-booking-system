package com.idrunk.controller.dtos;

import com.idrunk.models.Tafel;

public class TafelInputDto {

    public Long tafelNr;
    public int maxGuest;
    public Long id;

    public Tafel toTafel() {
        var tafel = new Tafel();
        tafel.setTafelNr(tafelNr);
        tafel.setMaxGuest(maxGuest);
        tafel.setId(id);

        return tafel;
    }
}