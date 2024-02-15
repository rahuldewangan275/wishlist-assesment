package com.example.wishlistmanagementtask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Bean
    @SuppressWarnings("removal")
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
  http.csrf().disable()
          .authorizeHttpRequests()
          .requestMatchers("/login")
          .permitAll()
          .requestMatchers("/api/**")
          .hasRole("USER")
          .anyRequest()
          .authenticated().and().formLogin();
        return http.build();
    }
//
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user1 = User.withUsername("u")
                .password(passwordEncoder().encode("u"))
                .roles("USER")
                .build();

        UserDetails user2 = User.withUsername("user2@gmail.com")
                .password(passwordEncoder().encode("user2Pass"))
                .roles("USER")
                .build();

        UserDetails user3 = User.withUsername("user3@gmail.com")
                .password(passwordEncoder().encode("user3Pass"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user1,user2,user3);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
