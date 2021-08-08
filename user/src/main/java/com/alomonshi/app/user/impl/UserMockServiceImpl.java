package com.alomonshi.app.user.impl;

import com.alomonshi.app.service.user.entity.User;
import com.alomonshi.app.service.user.service.UserService;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class UserMockServiceImpl implements UserService {

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
        User user = new User();
        user.setId(10L);
        user.setName("test");
        user.setEmail("test@alomonshi.com");
        return user;
    }
}