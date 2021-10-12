package com.idrunk.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "request_drink_amounts")
public class RequestDrinkAmount {

    @EmbeddedId
    private RequestDrinkAmountKey id;

    @ManyToOne
    @MapsId("requestId")
    @JoinColumn(name = "request_id")
    private Request request;

    @ManyToOne
    @MapsId("drinkId")
    @JoinColumn(name = "drink_id")
    private Drink drink;

    @Column
    private Long amount;

    public RequestDrinkAmountKey getId() {
        return id;
    }

    public void setId(RequestDrinkAmountKey id) {
        this.id = id;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }



}
