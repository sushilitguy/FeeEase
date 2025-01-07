package com.softmania.FeeEase.config;

import com.softmania.FeeEase.service.UserDataService;
import com.softmania.FeeEase.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class AppSecurityConfig {
    @Autowired
    private UserDataService userService;

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity security) throws Exception {
        security.csrf(customizer -> customizer.disable());
        security.authorizeHttpRequests(request -> request
                .requestMatchers(HttpMethod.POST,"/fee_ease/api/login","/fee_ease/api/users","/fee_ease/api/school").permitAll()
                .anyRequest().authenticated());
        security.formLogin(Customizer.withDefaults()); // To display default login form
        security.httpBasic(Customizer.withDefaults()); // To be used for enabling authentication for REST API
        security.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // Makes sessions stateless
//        security.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return security.build();
    }

    @Bean
    public AuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        authProvider.setUserDetailsService(userService);
        return authProvider;
    }

    @Bean
    public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}