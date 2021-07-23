package com.alomonshi.app.webapp.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("")
public class HomePage {
    @GET
    @Path("")
    public String getHellow () {
        return "Welcome to alomonshi web application...";
    }
}
