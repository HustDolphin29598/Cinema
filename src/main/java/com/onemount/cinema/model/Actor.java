package com.onemount.cinema.model;

import com.onemount.cinema.enums.Country;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Actor {
    private int id;
    private String name;
    private int age;
    private Country country;
}
