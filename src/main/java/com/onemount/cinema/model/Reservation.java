package com.onemount.cinema.model;

import com.onemount.cinema.enums.PaymentMethod;
import com.onemount.cinema.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "reservation")
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    private OrderLine orderLine;

    private ReservationStatus status;

    private PaymentMethod paymentMethod;

//    private Reservation reservation;
}
