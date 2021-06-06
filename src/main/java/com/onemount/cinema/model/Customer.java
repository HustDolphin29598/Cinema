package com.onemount.cinema.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onemount.cinema.enums.CustomerType;
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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

    private String fullName;

    private String hashedPassword;

    private String address;

    private String phone;

    private Date createdAt;

    private Date updatedAt;

    private int point;

    @Enumerated(EnumType.STRING)
    private CustomerType type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
//    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

//    @JsonGetter(value = "orders")
//    @Transient
//    public getOrder

    public Customer(String userName, String fullName, String hashedPassword, String address, String phone, Date createdAt, Date updatedAt, int point, CustomerType type) {
        this.userName = userName;
        this.fullName = fullName;
        this.hashedPassword = hashedPassword;
        this.address = address;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.point = point;
        this.type = type;
    }
}
