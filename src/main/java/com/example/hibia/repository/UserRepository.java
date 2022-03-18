package com.example.hibia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hibia.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
