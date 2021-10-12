package com.idrunk.controller.dtos;

import com.idrunk.models.*;

import java.util.Collection;
import java.util.Set;

public class RequestInputDto {

    public String username;
    public Collection<Long> drinkIdList;
    //is dit de Long die niet converted kan worden naar String??
//    public int amount;
    public boolean hasBeenServed;
    public Collection<RequestDrinkAmount> amountSet;


    public Request toRequest(){

        var request = new Request();

        request.setHasBeenServed(false);

        return request;
    }
}