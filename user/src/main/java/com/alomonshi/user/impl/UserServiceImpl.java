package com.alomonshi.user.impl;

import com.alomonshi.app.service.entity.User;
import com.alomonshi.app.service.services.user.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static List<User> users = new ArrayList<>();

    @Override
    public void add(User user) {
        user.setId(users.size() + 1L);
        users.add(user);
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
    }

    @Override
    public User get(Long id) {
        if (users.stream().anyMatch(o -> o.getId().equals(id)))
            return users.stream().filter(o -> o.getId().equals(id)).findFirst().get();
        return null;
    }
}