package com.onemount.cinema.response;

import com.onemount.cinema.model.User;
import lombok.Data;

@Data
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private User user;
    public LoginResponse(String accessToken, User user) {
        this.accessToken = accessToken;
        this.user = user;
    }
}
