package com.example.hibia.controller;

import com.example.hibia.advice.exception.CUserNotFoundException;
import com.example.hibia.domain.User;
import com.example.hibia.dto.UserDTO;
import com.example.hibia.model.response.CommonResult;
import com.example.hibia.model.response.ListResult;
import com.example.hibia.model.response.SingleResult;
import com.example.hibia.repository.UserRepository;
import com.example.hibia.service.ResponseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.hibia.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "user")
public class UserController {

	private final UserService userService;
	private final UserRepository userRepository;
	private final ResponseService responseService;

	@GetMapping(value = "/list")
	public ListResult<User> findAllUsers(){
		return responseService.getListResult(userService.findAllUsers());
	}

	@GetMapping(value = "/{id}")
	public SingleResult<User> findUserById(@PathVariable Long id, @RequestParam String lang){
		return responseService.getSingleResult(userService.findUser(id).orElseThrow(CUserNotFoundException::new));
	}

	@PostMapping(value = "")
	public SingleResult<User> saveUser(@RequestBody UserDTO userDTO){
		return responseService.getSingleResult(userService.saveUser(userDTO));
	}

	@PutMapping(value = "/")
	public SingleResult<User> updateUser(@RequestParam Long id, @RequestParam String email, @RequestParam String username, @RequestParam String passwd, @RequestParam String mobile){
		User user = User.builder()
				.id(id)
				.email(email)
				.username(username)
				.passwd(passwd)
				.mobile(mobile)
				.build();

		return responseService.getSingleResult(userRepository.save(user));
	}

	@DeleteMapping(value = "/{id}")
	public CommonResult deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return responseService.getSuccessResult();
	}
}
