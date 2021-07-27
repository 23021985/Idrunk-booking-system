package com.idrunk.services;

import com.idrunk.models.Drink;
import com.idrunk.models.Request;

import java.util.Arrays;
import java.util.List;

public interface RequestService {
    List<Request> getRequests();
    List<Request> getRequestsByUser(String username);
    void deleteRequest(Long id);
    void updateRequest(Long id, Request order);
    Request getRequest(Long id);
    Long createRequest(Request request);

}