package com.example.hibia.controller;

import com.example.hibia.domain.User;
import com.example.hibia.model.response.ListResult;
import com.example.hibia.service.ResponseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hibia.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "user")
public class UserController {

	private final UserService userService;
	private final ResponseService responseService;

	@GetMapping(value = "/users")
	public ListResult<User> findAllUsers(){
		return responseService.getListResult(userService.findAllUsers());
	}
}
