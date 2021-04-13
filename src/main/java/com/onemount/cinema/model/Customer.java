package com.onemount.cinema.model;

import com.onemount.cinema.enums.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    private String userName;
    private String fullName;
    private String hashedPassword;
    private String address;
    private String phone;
    private Date createdAt;
    private Date updatedAt;
    private int point;
    private CustomerType type;
}
