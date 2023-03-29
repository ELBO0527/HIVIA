package com.example.hibia.repository;

import com.example.hibia.domain.Role;
import com.example.hibia.domain.User;
import com.example.hibia.repository.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Test
    public void whenFindByUid() throws Exception {
        String uid = "test@gmail.com";
        String name = "testname";
        String mobile = "1234";
        //given
        userRepository.save(User.builder()
                        .email(uid)
                        .passwd(passwordEncoder.encode("1234"))
                        .username(name)
                        .roles(Collections.singleton(Role.ROLE_USER))
                        .mobile(mobile)
                        .balance(0)
                        .profile_url("test")
//                        .addr("addr")
//                        .addr_detail("detail")
//                        .zipcode("366666")
                        .birthday(LocalDate.ofEpochDay(2022-01-22))
                        .build());
        //when
        Optional<User> user = userRepository.findByUsername(name);

        //then
        assertNotNull(user);
        assertTrue(user.isPresent());
        assertEquals(user.get().getUsername(), name);
        assertThat(user.get().getEmail(), is(uid));
    }
    
}