package com.idrunk.services;

import com.idrunk.exceptions.RecordNotFoundException;
import com.idrunk.models.Drink;
import java.util.List;
import java.util.Set;

public interface DrinkService {

    List<Drink> getDrinks();

    Drink getDrink(long id) throws RecordNotFoundException;

    Drink saveDrink(Drink drink);

    void updateDrink(long id, Drink drink) throws RecordNotFoundException;

    void deleteDrink(Long id);

    Set<Drink> getDrinkSet (Long requestId);

    void addDrink(Long requestId, Long id);
    void removeDrink(Long requestId, Long id);

}