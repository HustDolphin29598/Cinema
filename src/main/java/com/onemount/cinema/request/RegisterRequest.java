package com.onemount.cinema.request;

import lombok.Data;

@Data
public class RegisterRequest {

    private String fullname;

    private String phone;

    private String email;

    private String address;

    private String password;
}
