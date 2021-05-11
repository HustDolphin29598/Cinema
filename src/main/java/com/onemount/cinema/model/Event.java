package com.onemount.cinema.model;

import com.onemount.cinema.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name = "event")
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date startTime;

    private Date endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="film_id")
    private Film film;

    private Seat seat;

    private int price;

    private EventStatus status;
}
