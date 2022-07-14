package com.example.hibia.service;

import com.example.hibia.advice.exception.CUserNotFoundException;
import com.example.hibia.domain.User;
import com.example.hibia.dto.UserDTO;
import com.example.hibia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserDetails loadUserByUsername(String username) {
		return userRepository.findById(Long.valueOf(username)).orElseThrow(CUserNotFoundException::new);
	}

	public List<User> findAllUsers(){
		return userRepository.findAll();
	}

	public User findUser(String id){
		return userRepository.findByUsername(id).orElseThrow(CUserNotFoundException::new);
	}

	public User saveUser(UserDTO userDTO){
		User user = User.builder()
				.birthday(userDTO.getBirthday())
				.username(userDTO.getUsername())
				.email(userDTO.getEmail())
				.mobile(userDTO.getMobile())
				.passwd(passwordEncoder.encode(userDTO.getPasswd()))
				.roles(Collections.singletonList("ROLE_USER"))
				.balance(userDTO.getBalance())
				.profile_url("/resources/img/default_profile.png")
				.build();
		return userRepository.save(user);
	}

	public User saveAdmin(UserDTO userDTO){
		User user = User.builder()
				.birthday(null)
				.username(userDTO.getUsername())
				.email(userDTO.getEmail())
				.mobile(userDTO.getMobile())
				.passwd(passwordEncoder.encode(userDTO.getPasswd()))
				.roles(Collections.singletonList("ROLE_ADMIN"))
				.balance(2147483647)
				.profile_url("/resources/img/default_profile.png")
				.build();
		return userRepository.save(user);
	}

	public User resetAdminPassword(String id, UserDTO userDTO){
		User user = findUser(id);
		user.setUser(userDTO.getEmail(), userDTO.getUsername(), "admin", userDTO.getBalance(), userDTO.getBirthday(), userDTO.getMobile());

		return null;
	}
	public User updateUser(String id,UserDTO userDTO){
			User user = findUser(id);
			user.setUser(userDTO.getEmail(), userDTO.getUsername(),  userDTO.getPasswd(), userDTO.getBalance(), userDTO.getBirthday(), userDTO.getMobile());
		return user;
	}

	public void deleteUser(String id){
		this.findUser(id);
		userRepository.deleteById(Long.valueOf(id));
	}
}
