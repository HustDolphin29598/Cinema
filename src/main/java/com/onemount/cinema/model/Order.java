package com.onemount.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private long totalAmount;
    private float discount;
}
