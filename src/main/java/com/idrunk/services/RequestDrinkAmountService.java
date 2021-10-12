package com.idrunk.services;

import com.idrunk.models.RequestDrinkAmount;
import com.idrunk.models.RequestDrinkAmountKey;

import java.util.Collection;

public interface RequestDrinkAmountService {

    Collection<RequestDrinkAmount> getAllAmounts();
    Collection<RequestDrinkAmount> getAmountsByRequestId(long requestId);
    Collection<RequestDrinkAmount> getAmountsByDrinkId(long drinkId);
    RequestDrinkAmount getAmountById(long requestId, long drinkId);

    RequestDrinkAmountKey addAmount(long requestId, long drinkId, RequestDrinkAmount amount);
    void updateAmount(long requestId, long drinkId, RequestDrinkAmount amount);
    void partialUpdateAmount(long requestId, long drinkId, RequestDrinkAmount amount);
    void deleteAmount(long requestId, long drinkId);

}
