package com.idrunk.controller.dtos;

import com.idrunk.models.User;

public class UserInputDto {
    public String userName;
    public String firstname;
    public String lastname;
    public String mail;

    public User toUser() {
        var user = new User();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setUsername(userName);
        user.setMail(mail);
        return user;

    }
}