package com.example.testframework;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class TestFrameworkApplicationTests {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void contextLoads() {
        String encode = bCryptPasswordEncoder.encode("test1234");
        System.out.println(encode);
        System.out.println(bCryptPasswordEncoder.matches("test1234",encode));
    }

}
