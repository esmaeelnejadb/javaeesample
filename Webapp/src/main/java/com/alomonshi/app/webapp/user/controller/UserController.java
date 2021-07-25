package com.alomonshi.app.webapp.user.controller;

import com.alomonshi.app.service.user.entity.User;
import com.alomonshi.app.service.user.service.UserService;
import com.alomonshi.app.webapp.user.dto.UserDto;
import com.alomonshi.user.impl.UserServiceImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;
import java.util.stream.Collectors;

@Path("user")
public class UserController {

    private UserService userService;

    public UserController() {
        this.userService = new UserServiceImpl();
    }

    @GET
    @Path("")
    public Response getUser (@QueryParam("id") Long userId) {
        UserDto userDto = new UserDto();
        User user = userService.get(userId);
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return Response.ok(userDto).build();
    }

    @POST
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser (UserDto userDto) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);

        violations.forEach(f-> System.out.println(f.getMessage()));

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        userService.add(user);
        return Response.ok(violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())).build();
    }
}
