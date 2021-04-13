package com.onemount.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Staff {
    private int id;
    private String fullName;
    private String staffCode;
    private int age;
    private int cinemaId;
}
