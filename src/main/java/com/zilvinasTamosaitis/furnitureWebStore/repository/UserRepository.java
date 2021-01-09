package com.zilvinasTamosaitis.furnitureWebStore.repository;

import com.zilvinasTamosaitis.furnitureWebStore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
