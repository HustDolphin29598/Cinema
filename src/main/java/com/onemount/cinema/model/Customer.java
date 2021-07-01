package com.onemount.cinema.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onemount.cinema.enums.CustomerType;
import com.onemount.cinema.request.RegisterRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "customer")
@Table(name = "customer")
public class Customer extends User{

    private String fullName;

    private String address;

    private int point;

    @Enumerated(EnumType.STRING)
    private CustomerType type;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id")
//    @JsonManagedReference
//    @JsonIgnore
//    private List<Order> orders = new ArrayList<>();

//    @JsonGetter(value = "orders")
//    @Transient
//    public getOrder

    public Customer(String fullName, String password, String address, String phone, String email,  int point, CustomerType type) {
        super(password, phone, email);
        this.fullName = fullName;
        this.address = address;
        this.point = point;
        this.type = type;
    }
}
