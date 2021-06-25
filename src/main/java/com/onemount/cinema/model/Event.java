package com.onemount.cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "event")
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalDate showingDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="film_id")
//    @JsonBackReference
    private Film film;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="room_id")
//    @JsonBackReference
    private Room room;

    public Event(LocalDate showingDate, LocalTime startTime, LocalTime endTime, Film film, Room room) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.film = film;
        this.room = room;
        this.showingDate = showingDate;
    }
}
