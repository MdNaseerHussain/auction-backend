package com.auction.live;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .authorizeRequests(auth -> auth
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2Login();
        // @formatter:on
        return http.build();
    }

}