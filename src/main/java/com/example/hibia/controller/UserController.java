package com.example.hibia.controller;

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

	@PostMapping(value = "/save")
	public SingleResult<User> saveUser(@RequestBody UserDTO userDTO){
		return responseService.getSingleResult(userService.saveUser(userDTO));
	}

	@PutMapping(value = "/update")
	public SingleResult<User> updateUser(@RequestParam(required = false) Long id, @RequestParam(required = false) String email, @RequestParam(required = false) String username, @RequestParam(required = false) String passwd, @RequestParam(required = false) String mobile){
		User user = User.builder()
				.id(id)
				.email(email)
				.username(username)
				.passwd(passwd)
				.mobile(mobile)
				.build();

		return responseService.getSingleResult(userRepository.save(user));
	}

	@DeleteMapping(value = "/delete/{id}")
	public CommonResult deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return responseService.getSuccessResult();
	}
}
