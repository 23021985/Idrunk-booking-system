package com.idrunk.repositories;
import com.idrunk.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

//    Collection<Drink> findAllByRequestId(Long requestId);
}