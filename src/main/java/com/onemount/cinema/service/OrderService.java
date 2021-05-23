package com.onemount.cinema.service;

import com.onemount.cinema.enums.CustomerType;
import com.onemount.cinema.enums.EventSeatStatus;
import com.onemount.cinema.enums.OrderStatus;
import com.onemount.cinema.exception.LogicException;
import com.onemount.cinema.exception.NotFoundException;
import com.onemount.cinema.model.*;
import com.onemount.cinema.repository.EventRepository;
import com.onemount.cinema.repository.EventSeatRepository;
import com.onemount.cinema.repository.OrderLineRepository;
import com.onemount.cinema.repository.OrderRepository;
import com.onemount.cinema.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    EventSeatRepository eventSeatRepository;

    @Autowired
    OrderLineRepository orderLineRepository;

    @Transactional
    public Order order(OrderRequest request){
        List<Integer> orderLineIdList = request.getOrderLineRequestId();
        List<OrderLine> orderLineList = new ArrayList<>();
        long totalAmount = 0;

        for(int orderLineId: orderLineIdList){
            OrderLine orderLine = orderLineRepository.findById(orderLineId);
            if(orderLine == null){
                throw new NotFoundException(orderLineId + " not found", "OrderLine");
            }
            EventSeat eventSeat = orderLine.getEventSeat();
            if(eventSeat.getStatus() == EventSeatStatus.IN_PROCESS || eventSeat.getStatus() == EventSeatStatus.RESERVED){
                throw new LogicException("EventSeat is already reserved or in processing !");
            }
            eventSeat.setStatus(EventSeatStatus.IN_PROCESS);
            eventSeatRepository.save(eventSeat);

            totalAmount += orderLine.getEventSeat().getPrice();
            orderLineList.add(orderLine);
        }

        Customer customer = orderLineList.get(0).getCustomer();
        float discountPct = 0;
        if(customer.getType() == CustomerType.VIP)
            discountPct = 0.3f;

        long pointDiscount = customer.getPoint()* 1000L;
        if(pointDiscount > totalAmount){
            totalAmount = 0;
            customer.setPoint((int) ((pointDiscount-totalAmount)/1000));
        }else{
            customer.setPoint(0);
            totalAmount -= pointDiscount;
        }

        Order order = Order.builder()
                .orderLineList(orderLineList)
                .orderStatus(OrderStatus.CREATED)
                .customer(customer)
                .totalAmount(totalAmount)
                .discount((int)totalAmount*discountPct)
                .time(new Time(new Date(), new Date()))
                .build();

        orderRepository.save(order);
        return order;
    }

    public List<Order> getCreatedStatusOrders(){
        return orderRepository.findByOrderStatus(OrderStatus.CREATED);
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }
}