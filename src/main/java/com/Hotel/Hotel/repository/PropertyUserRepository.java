package com.Hotel.Hotel.repository;

import com.Hotel.Hotel.entity.PropertyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertyUserRepository extends JpaRepository<PropertyUser, Long> {
    Optional<PropertyUser> findByUsername(String username);
}