package com.onemount.cinema.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    @NotBlank
    private String phone;

    private String email;

    @NotBlank
    private String password;

}
