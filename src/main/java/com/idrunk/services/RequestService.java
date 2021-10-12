package com.idrunk.services;

import com.idrunk.models.Drink;
import com.idrunk.models.Request;
import com.idrunk.models.RequestDrinkAmount;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface RequestService {
    List<Request> getRequests();
    List<Request> getRequestsByUser(String username);
    void deleteRequest(Long id);
    void updateRequest(Long id, Request order);
    Request getRequest(Long id);
    void saveRequest(String username, boolean hasBeenServed, Collection<RequestDrinkAmount> amountSet);


//    void createRequest(String username, Set<Drink> drinkSet, Long id, int amount, boolean hasBeenServed);
}