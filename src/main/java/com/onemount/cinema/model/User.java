package com.onemount.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    private String password;

    @Column(unique = true)
    private String phone;

    private String email;

    public User(String password, String phone, String email) {
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public User() {

    }
}
