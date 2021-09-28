package com.idrunk.controller.dtos;

import com.idrunk.models.Drink;
import com.idrunk.models.Request;
import com.idrunk.models.User;

import java.util.Set;

public class RequestInputDto {
    public Long id;
    User username;
    Set<Drink> drinkSet;


    public Request toRequest(){

        var request = new Request();
        request.setId(id);
        request.setUsername(username);
        request.setDrinkSet(drinkSet);
        request.setHasBeenServed(false);

        return request;
    }
}