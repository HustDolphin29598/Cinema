package com.onemount.cinema.model;

import com.onemount.cinema.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Event {
    private int id;
    private Date startTime;
    private Date endTime;
    private int filmId;
    private int seatId;
    private int price;
    private EventStatus status;
}
