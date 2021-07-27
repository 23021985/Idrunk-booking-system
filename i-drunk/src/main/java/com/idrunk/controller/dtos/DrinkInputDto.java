package com.idrunk.controller.dtos;
import com.idrunk.models.Drink;

public class DrinkInputDto {

    public Long id;

    public String name;

    public double price;

    public int stock;


    public Drink toDrink() {
        var drink = new Drink();
        drink.setId(id);
        drink.setName(name);
        drink.setPrice(price);
        drink.setStock(stock);
        return drink;
    }
}