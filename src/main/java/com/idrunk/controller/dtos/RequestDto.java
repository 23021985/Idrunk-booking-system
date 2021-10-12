package com.idrunk.controller.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.idrunk.models.Request;

import java.util.Collection;

public class RequestDto {
    public Long id;
    public Collection<Long> drinkSet;
    @JsonSerialize
    UserDto username;


    public double count;
    public static RequestDto fromRequest(Request request) {
        var dto = new RequestDto();


        return dto;
    }
}