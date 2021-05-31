package com.onemount.cinema.model;

import com.onemount.cinema.enums.OrderStatus;
import com.onemount.cinema.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "orders")
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private long totalAmount;

    private float discount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLineList = new ArrayList<>();

    public Order(PaymentMethod paymentMethod, OrderStatus orderStatus) {
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
    }

    @Embedded
    private Time time;
}
