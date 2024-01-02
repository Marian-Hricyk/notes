package com.Program1.notes.controlert;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {
  @Value("${spring.security.user.name}")
  private String username;

  @Value("${spring.security.user.password}")
  private String password;

  @Bean
  public UserDetailsService userDetailsService() {
    return new InMemoryUserDetailsManager(
            User.withDefaultPasswordEncoder()
                    .username(username)
                    .password(password)
                    .roles("USER")
                    .build());
  }
}
