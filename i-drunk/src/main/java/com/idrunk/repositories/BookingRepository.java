package com.idrunk.repositories;

import com.idrunk.models.Booking;
import com.idrunk.models.Tafel;
import com.idrunk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingByUser(User user);

    List<Booking> findByTafel(Tafel tafel);

    List<Booking> findByStartTimeBetweenAndTafel(LocalDateTime startTime, LocalDateTime endTime, Tafel tafel);

    List<Booking> findByEndTimeBetweenAndTafel(LocalDateTime startTime, LocalDateTime endTime, Tafel tafel);

    List<Booking> findByStartTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

}