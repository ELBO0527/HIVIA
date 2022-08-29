package com.example.hibia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hibia.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    //사용안하는 메서드
    Optional<User> findByUsername(String name);
    Optional<User> findByUsernameAndProvider(String name, String provider);
}
