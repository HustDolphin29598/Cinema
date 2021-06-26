package com.onemount.cinema.request;

import lombok.Data;

import java.util.List;

@Data
public class OrderLineListRequest {
    private int customerId;
    private List<Integer> bookingId;
}
