package com.idrunk.repositories;
import com.idrunk.models.Booking;
import com.idrunk.models.Tafel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TafelRepository extends JpaRepository <Tafel, Long>{
    Tafel getById(Long id);
}