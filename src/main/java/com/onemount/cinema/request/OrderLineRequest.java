package com.onemount.cinema.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderLineRequest {
    private int customerId;
    private int bookingId;
}
