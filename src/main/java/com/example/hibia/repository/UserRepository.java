package com.example.hibia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hibia.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String email);
}
