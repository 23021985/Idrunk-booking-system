package com.idrunk.services;

import com.idrunk.exceptions.RecordNotFoundException;
import com.idrunk.models.Drink;
import com.idrunk.models.Request;
import com.idrunk.models.RequestDrinkAmount;
import com.idrunk.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public
class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;
    private final RequestDrinkAmountRepository requestDrinkAmountRepository;
    private final UserRepository userRepository;
    private final DrinkRepository drinkRepository;

    @Autowired
    RequestServiceImpl(DrinkRepository drinkRepository, RequestDrinkAmountRepository requestDrinkAmountRepository, RequestRepository requestRepository, UserRepository userRepository) {
        this.requestRepository = requestRepository;
        this.requestDrinkAmountRepository = requestDrinkAmountRepository;
        this.userRepository = userRepository;
        this.drinkRepository = drinkRepository;
    }

    @Override
    public List<Request> getRequests() {
        return requestRepository.findAll();
    }

    @Override
    public List<Request> getRequestsByUser(String username) {
        var optionalUser = userRepository.findById(username);
        if (optionalUser.isPresent()) {
            var user = optionalUser.get();
            return requestRepository.findByUsername(user);
        } else {
            throw new RecordNotFoundException("De order is helaas niet gevonden");
        }
    }

    @Override
    public void updateRequest(Long id, Request request) {
        Optional<Request> optionalRequest = requestRepository.findById(id);
        if (optionalRequest.isPresent()) {
            requestRepository.deleteById(id);
            requestRepository.save(request);
        } else {
            throw new RecordNotFoundException("De bestelling is helaas niet gevonden");
        }
    }

    @Override
    public Request getRequest(Long id) {
        var optionalRequest = requestRepository.findById(id);
        if (optionalRequest.isEmpty()) {
            throw new RecordNotFoundException("De bestelling is helaas niet gevonden");
        } else {
            return optionalRequest.get();
        }
    }

    @Override
    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }

    @Override
    public void saveRequest(String username, boolean hasBeenServed, Collection<RequestDrinkAmount> amountSet){
        var optionalUsername = userRepository.findById(username);
        var user = optionalUsername.get();
        var request = new Request();
        request.setUsername(user);
        request.setHasBeenServed(false);
        requestRepository.save(request);


    }

//    @Override
//    public void createRequest(String username, Collection<Long> drinkIdList, boolean hasBeenServed) {
//
//        var optionalUser = userRepository.findById(username);
//        var user = optionalUser.get();
//        var request = new Request();
//        var requestSize = (long) requestRepository.findAll().size();
//
//        request.setId(requestSize +1);
//        request.setUsername(user);
//        request.setHasBeenServed(request.isHasBeenServed());
//        requestRepository.save(request);
//        request.setDrinkSet(drinkRepository.findAllByRequestId(request.getId()));
//
//    }

}
