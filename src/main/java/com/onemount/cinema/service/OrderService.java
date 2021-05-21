package com.onemount.cinema.service;

import com.onemount.cinema.repository.EventRepository;
import com.onemount.cinema.repository.OrderLineRepository;
import com.onemount.cinema.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    OrderLineRepository orderLineRepository;

    public void order(){

    }
}
