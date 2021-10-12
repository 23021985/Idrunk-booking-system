package com.idrunk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Drink {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private double price;

//    private int amount; Deze wordt later toegevoegd

//    @ManyToOne
//    Request request;

    @OneToMany(mappedBy = "drink")
    @JsonIgnore
    Set<RequestDrinkAmount>drinkSet;

//    private String drink;

    public Drink() {}

    public Drink(Long id) {

        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<RequestDrinkAmount> getDrinkSet() {
        return drinkSet;
    }

    public void setDrinkSet(Set<RequestDrinkAmount> drinkSet) {
        this.drinkSet = drinkSet;
    }

    //    public Object getDrink() {
//        return drink;
//    }
//
//    public void setDrink(String drink) {
//        this.drink = drink;
//    }

//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
}