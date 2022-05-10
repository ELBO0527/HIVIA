package com.example.hibia.controller;

import com.example.hibia.config.security.JwtTokenProvider;
import com.example.hibia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
//@RequestMapping(value = "")
public class SignController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;


}
