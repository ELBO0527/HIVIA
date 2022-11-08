package com.example.hibia.controller;

import com.example.hibia.advice.exception.CEmailSigninFailedException;
import com.example.hibia.config.security.JwtTokenProvider;
import com.example.hibia.domain.User;
import com.example.hibia.dto.SigninRequestDTO;
import com.example.hibia.dto.UserDTO;
import com.example.hibia.model.response.CommonResult;
import com.example.hibia.model.response.SingleResult;
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
//    public SingleResult<String> signin(@RequestParam(value = "id") String id, @RequestParam String passwd){
    public SingleResult<String> signin(@RequestBody SigninRequestDTO signinRequestDTO,@RequestParam(value = "ko",required = false) String lang){
        User user = userService.findUser(signinRequestDTO.getId());
        if(!passwordEncoder.matches(signinRequestDTO.getPasswd(), user.getPasswd()))
            throw new CEmailSigninFailedException();

        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(user.getId()),user.getRoles()));
    }

    @PostMapping(value = "/signup")
    public CommonResult signup(@RequestBody UserDTO userDTO){
        userService.saveUser(userDTO);
        return responseService.getSuccessResult();
    }

    //어드민 생성용 임시 api
    @PostMapping(value = "/adminsignup")
    public CommonResult adminSignup(@RequestBody UserDTO userDTO){
        userService.saveAdmin(userDTO);
        return responseService.getSuccessResult();
    }
}
