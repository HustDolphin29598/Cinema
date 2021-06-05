package com.onemount.cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onemount.cinema.enums.SeatType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "seat")
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "row_num")
    private String row;

    @Column(name = "column_num")
    private int column;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
//    @JsonBackReference
    @JsonIgnore
    private Room room;

    public Seat(String row, int column) {
        this.row = row;
        this.column = column;
    }

    @Enumerated(EnumType.STRING)
    private SeatType type;

    @OneToMany(mappedBy = "seat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonManagedReference
    @JsonIgnore
    private List<Booking> events = new ArrayList<>();
}
