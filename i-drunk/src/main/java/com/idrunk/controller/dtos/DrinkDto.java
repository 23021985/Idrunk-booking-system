package com.idrunk.controller.dtos;

import com.idrunk.models.Drink;

import java.util.List;

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
        dto.stock = drink.getStock();

        return dto;
    }

}