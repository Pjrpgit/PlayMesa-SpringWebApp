package com.example.auth.service;

import com.example.modelo.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}