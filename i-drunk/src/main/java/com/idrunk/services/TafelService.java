package com.idrunk.services;

import com.idrunk.models.Tafel;

import java.util.List;

public interface TafelService {

    List<Tafel> getTafel();

    Tafel getTafel(Long id);

    Tafel saveTafel(Tafel tafel);

    void deleteTafel(Long id);
}
