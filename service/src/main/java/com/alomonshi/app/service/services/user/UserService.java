package com.alomonshi.app.service.services.user;

import com.alomonshi.app.service.entity.User;

public interface UserService {

    void add(User user);
    void delete(Long id);
    void update(User user);
    User get(Long id);
}
