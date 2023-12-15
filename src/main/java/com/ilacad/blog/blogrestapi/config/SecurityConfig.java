package com.ilacad.blog.blogrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService () {

        UserDetails jc = User.builder()
                .username("jc")
                .password(passwordEncoder().encode("jc"))
                .roles("ADMIN")
                .build();


        UserDetails jp = User.builder()
                .username("jp")
                .password(passwordEncoder().encode("jp"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(jc, jp);
    }

    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> {
                    authorize.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }
}
