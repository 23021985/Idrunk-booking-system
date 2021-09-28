package com.idrunk.controller.dtos;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.idrunk.models.Booking;

import java.time.LocalDateTime;


public class BookingDto {

    public Long id;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime startTime;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime endTime;


    @JsonSerialize
    TafelDto tafel;

    @JsonSerialize
    UserDto user;


    public static BookingDto fromBooking(Booking booking) {
        var dto = new BookingDto();
        dto.id = booking.getId();
        dto.tafel = TafelDto.fromTafel(booking.getTafel());
        dto.user = UserDto.fromUser(booking.getUser());
        dto.startTime = booking.getStartTime();
        dto.endTime = booking.getEndTime();

        return dto;
    }
}