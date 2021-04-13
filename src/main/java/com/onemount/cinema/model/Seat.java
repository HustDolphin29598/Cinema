package com.onemount.cinema.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Seat {
    private int id;
    private String row;
    private String column;
    private int roomId;
}
