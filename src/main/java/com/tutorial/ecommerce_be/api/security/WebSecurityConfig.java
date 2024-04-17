package com.tutorial.ecommerce_be.api.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.beans.Customizer;

@Configuration
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //http.csrf().disable().cors().disable();
        http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable());
        //http.authorizeRequests().anyRequest().permitAll();
        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return http.build();
    }

}
