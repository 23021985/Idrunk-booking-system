package com.idrunk.services;

import com.idrunk.models.Tafel;

import java.util.List;

public interface TafelService {

    List<Tafel> getTafels();

    Tafel getTafel(Long id);

    Tafel saveTafel(Tafel tafel);

    void deleteTafel(Long id);

//    Object getTafel();
}
