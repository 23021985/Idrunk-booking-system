package com.idrunk.services;

import com.idrunk.exceptions.RecordNotFoundException;
import com.idrunk.models.Drink;
import com.idrunk.models.Request;
import com.idrunk.repositories.DrinkRepository;
import com.idrunk.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DrinkServiceImpl implements DrinkService{

    private DrinkRepository drinkRepository;
    private RequestRepository requestRepository;

    @Autowired
    public DrinkServiceImpl(DrinkRepository drinkRepository,
                            RequestRepository requestRepository){
        this.drinkRepository = drinkRepository;
        this.requestRepository = requestRepository;
    }

    @Override
    public List<Drink> getDrinks() {
        return drinkRepository.findAll();
    }


    @Override
    public Drink getDrink(long id) {
        Optional<Drink> drink = drinkRepository.findById(id);
        if (drink.isPresent()) {
            return drink.get();
        } else {
            throw new RecordNotFoundException("Het drankje is niet gevonden");
        }
    }

    @Override
    public Drink saveDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    @Override
    public void updateDrink(long id, Drink drink) {
        Optional<Drink> optionalDrink = drinkRepository.findById(id);
        if (optionalDrink.isPresent()) {
            drinkRepository.deleteById(id);
            drinkRepository.save(drink);
        } else {
            throw new RecordNotFoundException("Het drankje is niet gevonden");
        }
    }

    @Override
    public void deleteDrink(Long id) {
        drinkRepository.deleteById(id);
    }

    @Override
    public Set<Drink> getDrinkSet(Long requestId) {
        if(!requestRepository.existsById(requestId)) throw new RecordNotFoundException("no request was found");

        Request request = requestRepository.findById(requestId).get();

        return request.getDrinkSet();
    }

    @Override
    public void addDrink(Long requestId, Long id) {
        if (!requestRepository.existsById(requestId)) throw new RecordNotFoundException("no request was found");

        Request request = requestRepository.findById(requestId).get();
        request.addDrink(new Drink(id));

        requestRepository.save(request);
    }

    @Override
    public void removeDrink(Long requestId, Long id) {

        if (!requestRepository.existsById(requestId)) throw new RecordNotFoundException("no request was found");

        Request request = requestRepository.findById(requestId).get();

        Drink drinkToRemove = request.getDrinkSet().stream().filter((a) -> a.getDrink().equals(id)).findAny().get();

        request.removeDrink(drinkToRemove);

        requestRepository.save(request);

    }
}