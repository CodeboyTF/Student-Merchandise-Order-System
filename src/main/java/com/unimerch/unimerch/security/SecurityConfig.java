package com.unimerch.unimerch.security;

import com.unimerch.unimerch.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private MyUserDetailService userDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests( registry ->{
                    registry.requestMatchers( "/api/merch/fetchall", "/register/user" ).permitAll();
                    registry.requestMatchers("/api/merch/fetchall").hasRole("USER");
                    registry.requestMatchers("fetchall/password").hasRole("ADMIN");
                    registry.anyRequest().authenticated();               })
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();    }

               @Bean
               public AuthenticationProvider authenticationProvider(){
               DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
               provider.setUserDetailsService(userDetailService);
               provider.setPasswordEncoder(passwordEncoder());
               return provider;    }
               @Bean
               public BCryptPasswordEncoder passwordEncoder() {
               return new BCryptPasswordEncoder();    }}
