package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final AuthenticationManagerResolver<HttpServletRequest> authenticationManagerResolver;

    public WebSecurityConfig(AuthenticationManagerResolver<HttpServletRequest> authenticationManagerResolver) {
        this.authenticationManagerResolver = authenticationManagerResolver;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(
                request -> request
                        .antMatchers(HttpMethod.GET, "/products/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
        )
        .csrf()
        .disable()
        .oauth2ResourceServer(
                httpSecurityOAuth2ResourceServerConfigurer ->
                        httpSecurityOAuth2ResourceServerConfigurer
                                .jwt()
        );
    }
}
