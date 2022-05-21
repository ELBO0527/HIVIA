package com.example.hibia.controller.exception;

import com.example.hibia.config.security.CustomAuthenticationEntryPoint;
import com.example.hibia.model.response.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/exception")
public class ExceptionController {

    @GetMapping(value = "/entrypoint")
    public CommonResult entryPointException(){
        throw new CAuthenticationEntryPointException();
    }
}
