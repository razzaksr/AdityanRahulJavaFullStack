package org.controller.demo.SpringBoot_Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class CredSecurity {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails userDetails= User.withDefaultPasswordEncoder().username("aditya").password("zealous").roles("admin").build();
        List<UserDetails> memoryUser = Stream.of(userDetails).collect(Collectors.toList());
        return new InMemoryUserDetailsManager(memoryUser);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().anyRequest().authenticated();
        httpSecurity.httpBasic();
        httpSecurity.formLogin();
        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }
}
