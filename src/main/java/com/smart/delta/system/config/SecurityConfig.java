package com.smart.delta.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/oauth2/token").permitAll() // Доступ к токену
                        .anyRequest().authenticated() // Остальные запросы требуют аутентификации
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt()); // Включаем поддержку OAuth2 для JWT // Включаем анонимный доступ
        return http.build();
    }
}
