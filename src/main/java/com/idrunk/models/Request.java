package com.idrunk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Request  {

    @Id
    @GeneratedValue
    private Long id;
//    private int amount;
    private boolean hasBeenServed;

    @OneToMany(mappedBy = "request", fetch = FetchType.EAGER)
    @JsonIgnore
    Collection<RequestDrinkAmount> drinkSet;

    @OneToOne
    User username;

//    @OneToMany(mappedBy = "request")
//    Collection<Drink> drinkSet;

//    public Collection<Drink> getDrinkSet() {
//        return drinkSet;
//    }
//
//    public void setDrinkSet(Collection<Drink> drinkSet) {
//        this.drinkSet = drinkSet;
//    }


    public Collection<RequestDrinkAmount> getDrinkSet() {
        return drinkSet;
    }

    public void setDrinkSet(Collection<RequestDrinkAmount> drinkSet) {
        this.drinkSet = drinkSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public int getCount() {
//        return amount;
//    }
//
//    public void setCount(int count) {
//        this.amount = count;
//    }

    public boolean isHasBeenServed() {
        return hasBeenServed;
    }

    public void setHasBeenServed(boolean hasBeenServed) {
        this.hasBeenServed = hasBeenServed;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }

//    public void addDrink(Drink drink) {this.drinkSet.add(drink);}
//
//    public void removeDrink(Drink drink) {this.removeDrink(drink);}

}