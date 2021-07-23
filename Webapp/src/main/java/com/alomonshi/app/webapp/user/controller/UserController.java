package com.alomonshi.app.webapp.user.controller;

import com.alomonshi.app.service.user.entity.User;
import com.alomonshi.app.service.user.service.UserService;
import com.alomonshi.app.webapp.user.dto.UserDto;
import com.alomonshi.user.impl.UserServiceImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.Set;

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
    public void addUser (UserDto userDto) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);

        for (ConstraintViolation<UserDto> violation: violations)
            System.out.println(violation.getPropertyPath() + " " + violation.getMessage());

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        userService.add(user);
    }
}
