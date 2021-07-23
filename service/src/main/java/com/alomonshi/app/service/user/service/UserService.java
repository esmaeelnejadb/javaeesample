package com.alomonshi.app.service.user.service;

import com.alomonshi.app.service.user.entity.User;

public interface UserService {

    void add(User user);
    void delete(Long id);
    void update(User user);
    User get(Long id);
}
