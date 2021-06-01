package com.onemount.cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "room")
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cinema_id")
    @JsonBackReference
    private Cinema cinema;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
//    @JsonManagedReference
    @JsonIgnore
    private List<Seat> seats;

    public Room(String name) {
        this.name = name;
    }
}
