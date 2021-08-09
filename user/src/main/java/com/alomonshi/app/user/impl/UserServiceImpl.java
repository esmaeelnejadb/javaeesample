package com.alomonshi.app.user.impl;

import com.alomonshi.app.service.commons.annotations.qualifiers.UserRegisterEvent;
import com.alomonshi.app.service.commons.annotations.qualifiers.UserUpdateEvent;
import com.alomonshi.app.service.user.entity.User;
import com.alomonshi.app.service.user.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class UserServiceImpl implements UserService {

    private static List<User> users = new ArrayList<>();

    @UserRegisterEvent
    @Inject
    private Event<User> registeredUser;

    @UserUpdateEvent
    @Inject
    private Event<User> updatedUser;

    @Override
    public void add(User user) {
        user.setId(users.size() + 1L);
        users.add(user);
        registeredUser.fire(user);
    }

    @Override
    public void delete(Long id) {
        users.removeIf(o -> o.getId().equals(id));
    }

    @Override
    public void update(User user) {
        users.stream().filter(o -> o.getId().equals(user.getId())).forEach(f -> {
            f.setName(user.getName());
            f.setEmail(user.getEmail());
        });
        updatedUser.fire(user);
    }

    @Override
    public User get(Long id) {
        if (users.stream().anyMatch(o -> o.getId().equals(id)))
            return users.stream().filter(o -> o.getId().equals(id)).findFirst().get();
        return null;
    }
}