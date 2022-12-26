package com.example.hibia.model.request.user.social;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetKakaoAuth {

    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;

}
