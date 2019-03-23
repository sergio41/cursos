package com.cursos.springboot.rest.springbootrest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2_console/**").permitAll()
                .anyRequest().permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}