package com.onemount.cinema.request;

import com.onemount.cinema.enums.PaymentMethod;
import lombok.Data;

@Data
public class PayRequest {
    private int orderId;
    private String paymentMethod;
    private long amount;
}
