package com.idrunk.services;

import com.idrunk.exceptions.RecordNotFoundException;
import com.idrunk.models.Drink;
import com.idrunk.models.Request;
import com.idrunk.models.RequestDrinkAmount;
import com.idrunk.models.RequestDrinkAmountKey;
import com.idrunk.repositories.DrinkRepository;
import com.idrunk.repositories.RequestDrinkAmountRepository;
import com.idrunk.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RequestDrinkAmountServiceImpl implements RequestDrinkAmountService {

    @Autowired
    DrinkRepository drinkRepository;
    @Autowired
    RequestRepository requestRepository;
    @Autowired
    RequestDrinkAmountRepository requestDrinkAmountRepository;

    @Override
    public Collection<RequestDrinkAmount> getAllAmounts() {
        Collection<RequestDrinkAmount> amounts = requestDrinkAmountRepository.findAll();
        return amounts;
    }

    @Override
    public Collection<RequestDrinkAmount> getAmountsByRequestId(long requestId) {
        return requestDrinkAmountRepository.findAllByRequestId(requestId);
    }

    @Override
    public Collection<RequestDrinkAmount> getAmountsByDrinkId(long drinkId) {
        return requestDrinkAmountRepository.findAllByDrinkId(drinkId);
    }

    @Override
    public RequestDrinkAmount getAmountById(long requestId, long drinkId) {
        return requestDrinkAmountRepository.findById(new RequestDrinkAmountKey(requestId, drinkId)).orElse(null);
    }

    @Override
    public RequestDrinkAmountKey addAmount(long requestId, long drinkId, RequestDrinkAmount amount) {
        if (!requestRepository.existsById(requestId)) { throw new RecordNotFoundException(); }
        Request request = requestRepository.findById(requestId).orElse(null);
        if (!drinkRepository.existsById(drinkId)) { throw new RecordNotFoundException(); }
        Drink drink = drinkRepository.findById(drinkId).orElse(null);
        amount.setRequest(request);
        amount.setDrink(drink);
        RequestDrinkAmountKey id = new RequestDrinkAmountKey(requestId, drinkId);
        amount.setId(id);
        requestDrinkAmountRepository.save(amount);
        return id;
    }

    @Override
    public void updateAmount(long requestId, long drinkId, RequestDrinkAmount amount) {

    }

    @Override
    public void partialUpdateAmount(long requestId, long drinkId, RequestDrinkAmount amount) {
        RequestDrinkAmountKey id = new RequestDrinkAmountKey(requestId, drinkId);
        if (!requestDrinkAmountRepository.existsById(id)) { throw new RecordNotFoundException(); }
        RequestDrinkAmount existingAmount = requestDrinkAmountRepository.findById(id).orElse(null);
        if (amount.getAmount() != null) {
            existingAmount.setAmount(amount.getAmount());
        }
        requestDrinkAmountRepository.save(existingAmount);
    }

    @Override
    public void deleteAmount(long requestId, long drinkId) {
        RequestDrinkAmountKey id = new RequestDrinkAmountKey(requestId, drinkId);
        if (!requestDrinkAmountRepository.existsById(id)) { throw new RecordNotFoundException(); }
        requestDrinkAmountRepository.deleteById(id);
    }
}


