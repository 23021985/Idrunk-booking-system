package com.idrunk.services;
import com.idrunk.exceptions.RecordNotFoundException;
import com.idrunk.models.Tafel;
import com.idrunk.repositories.TafelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TafelServiceImpl implements TafelService {

    private TafelRepository tafelRepository;

    @Autowired
    public TafelServiceImpl(TafelRepository tafelRepository) {
        this.tafelRepository = tafelRepository;
    }

    @Override
    public List<Tafel> getTafel() {return tafelRepository.findAll();}

    @Override
    public Tafel getTafel(Long id) {
        Optional<Tafel> tafel = tafelRepository.findById(id);
        if (tafel.isPresent()) {
            return tafel.get();
        } else {
            throw new RecordNotFoundException("De tafel is niet gevonden");
        }
    }

    @Override
    public Tafel saveTafel(Tafel tafel) {
        return tafelRepository.save(tafel);
    }

    @Override
    public void deleteTafel(Long id) {
        tafelRepository.deleteById(id);
    }
}