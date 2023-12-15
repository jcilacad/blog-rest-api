package com.ilacad.blog.blogrestapi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BcryptPasswordGenerator {

    public static void main(String[] args) {

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("jcilacad"));
        System.out.println(encoder.encode("jpilacad"));
    }
}
