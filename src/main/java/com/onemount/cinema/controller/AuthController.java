package com.onemount.cinema.controller;

import com.onemount.cinema.jwt.JwtTokenProvider;

import com.onemount.cinema.model.CustomUserDetails;
import com.onemount.cinema.model.Customer;
import com.onemount.cinema.model.User;
import com.onemount.cinema.request.LoginRequest;
import com.onemount.cinema.request.RegisterRequest;
import com.onemount.cinema.response.LoginResponse;
import com.onemount.cinema.service.CustomerService;
import com.onemount.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }

    @PostMapping("/login")
    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getPhone(),
                        loginRequest.getPassword()
                )
        );


        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        User user = userService.getUserByPhone(loginRequest.getPhone());
        return new LoginResponse(jwt, user);
    }

    @PostMapping("/register")
    public Customer createNewCustomer(@RequestBody RegisterRequest request) {
        return customerService.createCustomer(request.getFullname(), passwordEncoder.encode(request.getPassword()), request.getAddress(), request.getPhone(), request.getEmail(), 0, null);
    }
}
