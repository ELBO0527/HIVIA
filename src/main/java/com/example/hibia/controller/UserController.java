package com.example.hibia.controller;

import com.example.hibia.domain.User;
import com.example.hibia.model.request.user.UserDTO;
import com.example.hibia.model.response.CommonResult;
import com.example.hibia.model.response.ListResult;
import com.example.hibia.model.response.SingleResult;
import com.example.hibia.model.response.user.UserResponse;
import com.example.hibia.service.ResponseService;
import com.example.hibia.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

	private final UserService userService;
	private final ResponseService responseService;

	@GetMapping(value = "/list")
	public ResponseEntity<List<UserResponse>> findAllUsers(){
		return ResponseEntity.ok(userService.findAllUsers());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserResponse> findUserById(@PathVariable Long id){
		return ResponseEntity.ok(userService.findUser(id));
	}

	@PostMapping(value = "/signup")
	public void saveUser(@RequestBody UserDTO userDTO){
		userService.saveUser(userDTO);
	}

	@PutMapping(value = "/{id}")
	public void updateUser(@PathVariable Long id, @RequestBody UserDTO userDto){
		userService.updateUser(id, userDto);
	}

	@DeleteMapping(value = "/{id}")
	public CommonResult deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return responseService.getSuccessResult();
	}
}
