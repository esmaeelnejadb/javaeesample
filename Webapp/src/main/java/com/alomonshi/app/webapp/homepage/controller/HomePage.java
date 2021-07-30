package com.alomonshi.app.webapp.homepage.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/homepage")
public class HomePage {

    @GET
    public String getHello() {
        return "Welcome to alomonshi web application...";
    }
}
