package com.idrunk.controller.dtos;

import com.idrunk.models.User;

public class UserDto {
    public String username;
    public String firstname;
    public String lastname;
    public String email;

    public static UserDto fromUser(User user) {
        var dto = new UserDto();
        dto.username = user.getUsername();
        dto.firstname = user.getFirstName();
        dto.lastname = user.getLastName();
        dto.email = user.getEmail();
        return dto;
    }
}