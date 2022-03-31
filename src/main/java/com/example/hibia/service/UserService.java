package com.example.hibia.service;

import com.example.hibia.advice.exception.CUserNotFoundException;
import com.example.hibia.domain.User;
import com.example.hibia.dto.UserDTO;
import com.example.hibia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
	
	private final UserRepository userRepository;

	public List<User> findAllUsers(){
		return userRepository.findAll();
	}

	public User findUser(Long id){
		return userRepository.findById(id).orElseThrow(CUserNotFoundException::new);
	}

	public User saveUser(UserDTO userDTO){
		User user = User.builder()
				.birthday(userDTO.getBirthday())
				.username(userDTO.getUsername())
				.email(userDTO.getEmail())
				.mobile(userDTO.getMobile())
				.passwd(userDTO.getPasswd())
				.build();
		return userRepository.save(user);
	}

	public User updateUser(Long id,UserDTO userDTO){
			User user = findUser(id);
			user.setUser(userDTO.getEmail(), userDTO.getUsername(), userDTO.getPasswd(), userDTO.getBirthday(), userDTO.getMobile());
		return user;
	}

	public void deleteUser(Long id){
		this.findUser(id);
		userRepository.deleteById(id);
	}
}
