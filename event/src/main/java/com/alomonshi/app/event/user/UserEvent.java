package com.alomonshi.app.event.user;

import com.alomonshi.app.service.commons.annotations.qualifiers.UserRegisterEvent;
import com.alomonshi.app.service.commons.annotations.qualifiers.UserUpdateEvent;
import com.alomonshi.app.service.user.entity.User;

import javax.enterprise.event.Observes;

public class UserEvent {

    public void userUpdateEvent(@Observes @UserUpdateEvent User user) {
        System.out.println("Updated user : " + user.getId());
    }

    public void userRegisterEvent(@Observes @UserRegisterEvent User user) {
        System.out.println("Registered user : " + user.getName());
    }

}
