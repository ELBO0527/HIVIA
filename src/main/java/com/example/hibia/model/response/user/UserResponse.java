package com.example.hibia.model.response.user;

import com.example.hibia.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class UserResponse {
    private String email;
    private String username;
    private LocalDate birthday;
    private String mobile;
    private int balance;
    private String profile_url;

    public UserResponse(final User user) {
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.birthday = user.getBirthday();
        this.mobile = user.getMobile();
        this.balance = user.getBalance();
        this.profile_url = user.getProfile_url();
    }
}
