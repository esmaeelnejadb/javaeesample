package com.alomonshi.app.webapp.user.controller;

import com.alomonshi.app.service.commons.annotations.qualifiers.Produce;
import com.alomonshi.app.service.user.entity.User;
import com.alomonshi.app.service.user.service.UserService;
import com.alomonshi.app.webapp.user.dto.UserDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;
import java.util.stream.Collectors;

@RequestScoped
@Path("user")
public class UserController {

    @Produce
    @Inject
    private UserService userService;

    @Inject Validator validator;

    @GET
    public Response getUser (@QueryParam("id") @NotNull Long userId) {

        Set<ConstraintViolation<Long>> violations = validator.validate(userId);

        violations.forEach(f-> System.out.println(f.getMessage()));

        UserDto userDto = new UserDto();
        User user = userService.get(userId);
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return Response.ok(userDto).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser (UserDto userDto) {

        Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);

        violations.forEach(f-> System.out.println(f.getMessage()));

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        userService.add(user);
        return Response.ok(violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())).build();
    }
}
