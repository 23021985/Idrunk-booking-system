package com.idrunk.repositories;
import com.idrunk.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

}