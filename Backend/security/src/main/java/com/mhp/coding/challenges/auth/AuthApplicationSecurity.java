package com.mhp.coding.challenges.auth;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AuthApplicationSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
    .antMatchers(HttpMethod.PUT, "/v1/doors").hasRole("emailX").anyRequest().permitAll();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/**").authorizeRequests()
//                .antMatchers(HttpMethod.PUT, "/v1/doors/{id:\\d+}").access("hasAuthority('email')")
//                .anyRequest().permitAll();
//        http.cors().disable().authorizeRequests()
//                .antMatchers(HttpMethod.PUT, "/v1/doors/**").hasAuthority("email")
//                .anyRequest().permitAll();
//
//    }
}
