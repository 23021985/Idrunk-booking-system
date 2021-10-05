package com.idrunk.services;

import com.idrunk.exceptions.RecordNotFoundException;
import com.idrunk.models.Drink;
import com.idrunk.models.Request;
import com.idrunk.repositories.DrinkRepository;
import com.idrunk.repositories.RequestRepository;
import com.idrunk.repositories.TafelRepository;
import com.idrunk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public
class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;
    private final UserRepository userRepository;
    private final DrinkRepository drinkRepository;

    @Autowired
    RequestServiceImpl(DrinkRepository drinkRepository, RequestRepository requestRepository, UserRepository userRepository) {
        this.requestRepository = requestRepository;
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
    public Long createRequest(Request request) {
        request.setId(request.getId());
        request.setUsername(request.getUsername());
        request.setHasBeenServed(request.isHasBeenServed());
        Request newRequest = requestRepository.save(request);

        return newRequest.getId();

    }

}
