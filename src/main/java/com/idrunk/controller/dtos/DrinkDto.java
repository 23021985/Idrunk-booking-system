package com.idrunk.controller.dtos;

import com.idrunk.models.Drink;

public class DrinkDto {

    public Long id;

    public double price;

    public String name;

    public int stock;


    public static DrinkDto fromDrink(Drink drink){
        var dto = new DrinkDto();
        dto.id = drink.getId();
        dto.name = drink.getName();
        dto.price = drink.getPrice();
//        dto.stock = drink.getAmount();

        return dto;
    }

}