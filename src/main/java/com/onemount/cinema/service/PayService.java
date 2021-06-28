package com.onemount.cinema.service;

import com.github.javafaker.Faker;
import com.onemount.cinema.enums.BookingStatus;
import com.onemount.cinema.enums.OrderStatus;
import com.onemount.cinema.exception.LogicException;
import com.onemount.cinema.exception.NotFoundException;
import com.onemount.cinema.model.Order;
import com.onemount.cinema.model.OrderLine;
import com.onemount.cinema.model.Ticket;
import com.onemount.cinema.model.Time;
import com.onemount.cinema.repository.OrderLineRepository;
import com.onemount.cinema.repository.OrderRepository;
import com.onemount.cinema.request.PayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class PayService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderLineRepository orderLineRepository;

    private final Faker faker = new Faker();

    @Transactional
    public Order pay(PayRequest request){

        int orderId = request.getOrderId();
        Order order = orderRepository.findById(orderId);

        if (orderId == 0){
            throw new LogicException("Order ID must be positive !");
        }

        if(order == null){
            throw new NotFoundException(orderId + " not found", "Order");
        }

        order.setPaymentMethod(request.getPaymentMethod());
        order.setTime(new Time(order.getTime().getCreatedAt(), new Date()));


        if(request.getAmount() < order.getTotalAmount() - order.getDiscount()){
            for(OrderLine orderLine: orderLineRepository.findByOrderId(orderId)){
                orderLine.getBooking().setStatus(BookingStatus.AVAILABLE);
            }
            order.setOrderStatus(OrderStatus.FAILURE);
            order.setTime(new Time(order.getTime().getCreatedAt(), new Date()));
            orderRepository.save(order);
            throw new LogicException("Not enough money");
        }

        List<OrderLine> paidOrderLines = orderLineRepository.findByOrderId(orderId);
        for(OrderLine orderLine: paidOrderLines){
            orderLine.getBooking().setStatus(BookingStatus.RESERVED);
            Ticket ticket = Ticket.builder()
                    .orderLine(orderLine)
                    .time(new Time(new Date(), new Date()))
                    .code(faker.code().imei())
                    .build();
            orderLine.setTicket(ticket);
        }
        order.setOrderStatus(OrderStatus.SUCCESS);
        order.setTime(new Time(order.getTime().getCreatedAt(), new Date()));

        orderRepository.save(order);
        return order;
    }
}
