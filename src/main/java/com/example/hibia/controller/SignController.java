package com.example.hibia.controller;

import com.example.hibia.advice.exception.CEmailSigninFailedException;
import com.example.hibia.config.security.JwtTokenProvider;
import com.example.hibia.domain.User;
import com.example.hibia.dto.UserDTO;
import com.example.hibia.model.response.CommonResult;
import com.example.hibia.model.response.SingleResult;
import com.example.hibia.repository.UserRepository;
import com.example.hibia.service.ResponseService;
import com.example.hibia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/sign")
public class SignController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final ResponseService responseService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(value = "/signin")
    public SingleResult<String> signin(@RequestParam(value = "id") String id, @RequestParam String passwd){
        User user = userService.findUser(id);
        if(!passwordEncoder.matches(passwd, user.getPasswd()))
            throw new CEmailSigninFailedException();

        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(user.getId()),user.getRoles()));
    }

    @PostMapping(value = "/signup")
    public CommonResult signin(@RequestBody UserDTO userDTO){
        userService.saveUser(userDTO);
        return responseService.getSuccessResult();
    }


}
