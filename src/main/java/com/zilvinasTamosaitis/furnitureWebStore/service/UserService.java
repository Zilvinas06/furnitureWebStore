package com.zilvinasTamosaitis.furnitureWebStore.service;

import com.zilvinasTamosaitis.furnitureWebStore.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
