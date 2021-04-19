package com.onemount.cinema.model;

import com.onemount.cinema.enums.OrderLineStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "order_line")
@Table(name = "order_line")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date createdAt;

    private Date updatedAt;

    private int eventId;

    private int orderId;

    private int customerId;

    private OrderLineStatus status;
}
