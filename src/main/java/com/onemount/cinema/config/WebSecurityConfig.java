package com.onemount.cinema.config;

import com.onemount.cinema.jwt.JwtAuthenticationFilter;
import com.onemount.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@Component
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // Get AuthenticationManager bean
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin().and()
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/film").permitAll()
                .antMatchers("/event").permitAll()
                .antMatchers("/cinemas").permitAll()
                .antMatchers("/booking").permitAll()
                .antMatchers("/auth/register").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/user").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
