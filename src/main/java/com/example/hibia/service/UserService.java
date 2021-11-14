package com.example.hibia.service;

import org.springframework.stereotype.Service;

import com.example.hibia.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
}
