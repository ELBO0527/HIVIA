package com.example.hibia.controller.common;

import com.example.hibia.dto.RetKakaoAuth;
import com.example.hibia.model.response.SingleResult;
import com.example.hibia.service.KakaoService;
import com.example.hibia.service.ResponseService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/social/login")
public class SocialController {

    private final Environment env;
    private final Gson gson;
    private final RestTemplate restTemplate;
    private final KakaoService kakaoService;
    private final ResponseService responseService;

    @Value("${spring.url.base}")
    private String baseUrl;

    @Value("${spring.social.kakao.client_id}")
    private String kakaoClientId;

    @Value("${spring.social.kakao.redirect}")
    private String kakaoRedirect;

    @GetMapping(value = "/")
    public String main() {
        StringBuilder loginUrl= new StringBuilder()
                .append(env.getProperty("spring.social.kakao.url.login"))
                .append("?client_id=").append(kakaoClientId)
                .append("&response_type=code")
                .append("&redirect_uri=").append(baseUrl).append(kakaoRedirect);
        return String.valueOf(loginUrl);
    }

    @GetMapping(value = "/kakao")
    public SingleResult<RetKakaoAuth> redirectKakao(@RequestParam String code){
        return responseService.getSingleResult(kakaoService.getKakaoTokenInfo(code));
    }

}
