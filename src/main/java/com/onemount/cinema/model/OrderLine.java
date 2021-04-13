package com.onemount.cinema.model;

import com.onemount.cinema.enums.OrderLineStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine {
    private int id;
    private Date createdAt;
    private Date updatedAt;
    private int eventId;
    private int orderId;
    private int customerId;
    private OrderLineStatus status;
}
