package com.example.hibia.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserDTO {

    private String email;
    private String username;
    private String passwd;
    private LocalDate birthday;
    private String mobile;
    private int balance;
    private String profile_url;
    private String addr;
    private String addr_detail;
    private String zipcode;
    private String category;
}
