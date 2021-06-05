package com.onemount.cinema.request;

import com.onemount.cinema.enums.SeatType;
import lombok.Data;

@Data
public class SeatRequest {
    String rowName;
    int colNum;
    SeatType seatType;
}
