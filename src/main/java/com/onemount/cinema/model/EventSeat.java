package com.onemount.cinema.model;

import com.onemount.cinema.enums.EventSeatStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "event_seat")
@Table(name = "event_seat")
@Data
@NoArgsConstructor
public class EventSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_seat_id")
    private List<OrderLine> orderLineList = new ArrayList<>();

    private int price;

    @Enumerated(EnumType.STRING)
    private EventSeatStatus status;

    public EventSeat(Event event, Seat seat, int price, EventSeatStatus status) {
        this.event = event;
        this.seat = seat;
        this.price = price;
        this.status = status;
    }
}
