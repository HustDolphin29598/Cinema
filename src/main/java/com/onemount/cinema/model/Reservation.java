package com.onemount.cinema.model;

import com.onemount.cinema.enums.PaymentMethod;
import com.onemount.cinema.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    private int id;
    private int orderLineId;
    private ReservationStatus status;
    private PaymentMethod paymentMethod;
}
