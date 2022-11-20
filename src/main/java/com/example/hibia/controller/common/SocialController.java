package com.example.hibia.controller.common;

import com.example.hibia.advice.exception.CCommunicationException;
import com.example.hibia.advice.exception.CUserExistException;
import com.example.hibia.advice.exception.CUserNotFoundException;
import com.example.hibia.config.security.JwtTokenProvider;
import com.example.hibia.domain.User;
import com.example.hibia.dto.KakaoProfile;
import com.example.hibia.model.response.SingleResult;
import com.example.hibia.repository.UserRepository;
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

import java.util.Collections;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/social/login/")
public class SocialController {

    private final Environment env;
    private final Gson gson;
    private final RestTemplate restTemplate;
    private final KakaoService kakaoService;
    private final ResponseService responseService;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

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
    public SingleResult<String> redirectKakao(@RequestParam String code) throws CCommunicationException {

        String accessToken = kakaoService.getKakaoTokenInfo(code).getAccess_token();
        KakaoProfile profile = kakaoService.getKakaoProfile(accessToken);

        Optional<User> isUser = userRepository.findByUsernameAndProvider(String.valueOf(profile.getId()), "kakao");


        if(!isUser.isPresent()) {
            //throw new CUserExistException();

            User user = userRepository.save(User.builder()
                    .username(String.valueOf(profile.getId()))
                    .provider("kakao")
                    .roles(Collections.singletonList("ROLE_USER"))
                    .email("email")
                    .balance(0)
                    .build());
        }
        User user = userRepository.findByUsernameAndProvider(String.valueOf(profile.getId()), "kakao").orElseThrow(CUserNotFoundException::new);


        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(user.getId()), user.getRoles()));
    }

}
