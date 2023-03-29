package com.example.hibia.service.user;

import com.example.hibia.advice.exception.CUserNotFoundException;
import com.example.hibia.domain.Role;
import com.example.hibia.domain.User;
import com.example.hibia.model.request.user.UserDTO;
import com.example.hibia.model.response.user.UserResponse;
import com.example.hibia.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public List<UserResponse> findAllUsers(){
		return userRepository.findAll().stream().map(UserResponse::new).collect(Collectors.toList());
	}

	public UserResponse findUser(long id){
		User user = userRepository.findById(id).orElseThrow(CUserNotFoundException::new);
		return UserResponse.builder()
				.profile_url(user.getProfile_url())
				.email(user.getEmail())
				.mobile(user.getMobile())
				.username(user.getUsername())
				.birthday(user.getBirthday())
				.balance(user.getBalance())
				.build();
	}

	public void saveUser(UserDTO userDTO){
		User user = User.builder()
				.birthday(userDTO.getBirthday())
				.username(userDTO.getUsername())
				.email(userDTO.getEmail())
				.mobile(userDTO.getMobile())
				.passwd(passwordEncoder.encode(userDTO.getPasswd()))
				.roles(Collections.singleton(Role.ROLE_USER))
				.balance(0)
				.build();

		userRepository.save(user);
	}

	public void saveAdmin(UserDTO userDTO){
		User user = User.builder()
				.birthday(null)
				.username(userDTO.getUsername())
				.email(userDTO.getEmail())
				.mobile(userDTO.getMobile())
				.passwd(passwordEncoder.encode(userDTO.getPasswd()))
				.roles(Collections.singleton(Role.ROLE_ADMIN))
				.balance(2147483647)
				.build();

		userRepository.save(user);
	}

	public void resetAdminPassword(long id, UserDTO userDTO){
		User user = userRepository.findById(id).orElseThrow(CUserNotFoundException::new);
		user.setUser(userDTO.getEmail(), userDTO.getUsername(), passwordEncoder.encode("admin"),
				 userDTO.getBirthday(), userDTO.getMobile());

	}
	public void updateUser(long id,UserDTO userDTO){
		    User user = userRepository.findById(id).orElseThrow(CUserNotFoundException::new);
			user.setUser(userDTO.getEmail(), userDTO.getUsername(),  passwordEncoder.encode(userDTO.getPasswd()),
					userDTO.getBirthday(), userDTO.getMobile());
	}

	public void deleteUser(Long id){
		userRepository.deleteById(id);
	}
}
