package com.onemount.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {
    private int id;
    private int reservationId;
    private String code;
}
