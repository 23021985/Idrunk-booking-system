package com.idrunk.repositories;

import com.idrunk.models.RequestDrinkAmount;
import com.idrunk.models.RequestDrinkAmountKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;

public interface RequestDrinkAmountRepository extends JpaRepository <RequestDrinkAmount, RequestDrinkAmountKey> {

    Collection<RequestDrinkAmount> findAllByRequestId(long requestId);
    Collection<RequestDrinkAmount> findAllByDrinkId(long drinkId);
}
