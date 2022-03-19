package com.example.hibia.service;

import com.example.hibia.domain.User;
import com.example.hibia.dto.UserDTO;
import org.springframework.stereotype.Service;

import com.example.hibia.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;

	public List<User> findAllUsers(){
		return userRepository.findAll();
	}

	public Optional<User> findUser(Long id){
		return userRepository.findById(id);
	}

	public User saveUser(UserDTO userDTO){
		User user = User.builder()
				.id(userDTO.getId())
				.birthday(userDTO.getBirthday())
				.email(userDTO.getEmail())
				.mobile(userDTO.getMobile())
				.passwd(userDTO.getPasswd())
				.build();
		return userRepository.save(user);
	}
}
