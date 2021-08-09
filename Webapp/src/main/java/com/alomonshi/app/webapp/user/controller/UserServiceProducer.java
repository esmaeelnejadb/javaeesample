package com.alomonshi.app.webapp.user.controller;

import com.alomonshi.app.service.commons.annotations.qualifiers.Produce;
import com.alomonshi.app.service.user.service.UserService;
import com.alomonshi.app.user.impl.UserMockServiceImpl;
import com.alomonshi.app.user.impl.UserServiceImpl;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

@RequestScoped
public class UserServiceProducer {

    private static String ENVIRONMENT = "production";

    private UserService userService;

    @RequestScoped
    @Produce
    @Produces
    public UserService getUserService () {
        switch (ENVIRONMENT) {
            case "test":
                return new UserMockServiceImpl();
            case "production":
                return new UserServiceImpl();
            default:
                return null;
        }
    }

}
