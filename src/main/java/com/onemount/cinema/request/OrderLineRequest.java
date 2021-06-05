package com.onemount.cinema.request;

import lombok.Data;

@Data
public class OrderLineRequest {
    private int customerId;
    private int bookingId;
}
