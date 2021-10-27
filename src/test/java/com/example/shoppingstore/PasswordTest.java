package com.example.shoppingstore;


import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {

    @Test
    public void generarPassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
        String pass = encoder.encode("123");
        System.out.println(pass);
    }
}

//$2a$11$YRJpFVygwFS8bHLEhpCCX.ciBm3t7wrqgfm8iQNdiYK/b/muHaOfi