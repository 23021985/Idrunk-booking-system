package com.idrunk.controller.dtos;


import com.idrunk.models.Booking;

import java.time.LocalDateTime;

public class BookingInputDto {
    public Long tafelId;

    public LocalDateTime startTime;

    public LocalDateTime endTime;

    public String username;

    public Booking toBooking() {
        var booking = new Booking();
        booking.setStartTime(startTime);
        booking.setEndTime(endTime);

        return booking;
    }
}