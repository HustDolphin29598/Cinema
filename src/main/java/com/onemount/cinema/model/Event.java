package com.onemount.cinema.model;

import com.onemount.cinema.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "event")
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date startTime;

    private Date endTime;

    private int filmId;

    private int seatId;

    private int price;

    private EventStatus status;
}
