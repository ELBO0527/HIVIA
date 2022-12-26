package com.example.hibia.controller;

import com.example.hibia.domain.User;
import com.example.hibia.model.request.user.UserDTO;
import com.example.hibia.model.response.CommonResult;
import com.example.hibia.model.response.ListResult;
import com.example.hibia.model.response.SingleResult;
import com.example.hibia.service.ResponseService;
import com.example.hibia.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

	private final UserService userService;
	private final ResponseService responseService;

	@GetMapping(value = "/list")
	public ListResult<User> findAllUsers(){
		return responseService.getListResult(userService.findAllUsers());
	}

	@GetMapping(value = "/{id}")
	public SingleResult<User> findUserById(@PathVariable Long id){
		return responseService.getSingleResult(userService.findUser(id));
	}

	@PostMapping(value = "/signup")
	public SingleResult<User> saveUser(@RequestBody UserDTO userDTO){
		return responseService.getSingleResult(userService.saveUser(userDTO));
	}

	@PutMapping(value = "/{id}")
	public SingleResult<User> updateUser(@PathVariable Long id, @RequestBody UserDTO userDto){
		return responseService.getSingleResult(userService.updateUser(id, userDto));
	}

	@DeleteMapping(value = "/{id}")
	public CommonResult deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return responseService.getSuccessResult();
	}

	@PostMapping(value = "/uploadProfile")
	public ResponseEntity<?> uploadProfile(MultipartFile multipartFile){
		if (multipartFile.isEmpty()){

		}

		String fileName = "image.png";

		String downloadURI = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/download")
				.path(fileName)
				.toUriString();

		return new ResponseEntity<>(downloadURI, HttpStatus.OK);
	}
}
