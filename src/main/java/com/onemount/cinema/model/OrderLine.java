package com.onemount.cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "order_line")
@Table(name = "order_line")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
    @JsonBackReference
    private Booking booking;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Customer customer;

    @Embedded
    private Time time;
}
