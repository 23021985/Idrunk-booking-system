package com.idrunk.controller.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.idrunk.models.Request;

public class RequestDto {
    public Long id;
    @JsonSerialize
    UserDto username;
    @JsonSerialize
    DrinkDto drinkset;
    public double count;
    public static RequestDto fromRequest(Request request) {
        var dto = new RequestDto();


        return dto;
    }
}