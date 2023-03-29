package com.example.hibia.service.user;

import com.example.hibia.domain.Cart;
import com.example.hibia.domain.Role;
import com.example.hibia.domain.User;
import com.example.hibia.model.response.user.UserResponse;
import com.example.hibia.repository.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("유저정보를_전부_가져오는지_확인")
    public void findAllUsers() throws Exception{
        //givin
        UserResponse userResponse = UserResponse.builder()
                .mobile("1")
                .email("2@2")
//                .zipcode("12")
                .profile_url("ase")
                .balance(0)
                .username("test")
                .birthday(LocalDate.now())
//                .addr("addr")
//                .addr_detail("addrDeta")
                .build();

        UserResponse userResponse2 = UserResponse.builder()
                .mobile("1")
                .email("2@2")
//                .zipcode("12")
                .profile_url("ase")
                .balance(0)
                .username("test")
                .birthday(LocalDate.now())
//                .addr("addr")
//                .addr_detail("addrDeta")
                .build();

        List<UserResponse> userResponses = new ArrayList<>();
        userResponses.add(userResponse);
        userResponses.add(userResponse2);

        //when
        List<UserResponse> userResponseList = userService.findAllUsers();

        System.out.println("memberAll = " + userResponses);
        
        //then
        assertThat(userResponseList).isNotNull();
        assertThat(userResponses).hasSize(2);


    }

    @Test
    public void findUser() throws Exception{
        //givin
        
        //when
        
        //then
    }

    @Test
    public void signUp() throws Exception{
        //givin
        
        //when
        
        //then
    }

    @Test
    public void signUpAdmin() throws Exception{
        //givin
        
        //when
        
        //then
    }

    @Test
    void resetAdminPassword() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}