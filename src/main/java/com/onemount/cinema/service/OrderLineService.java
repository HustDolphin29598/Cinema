package com.onemount.cinema.service;

import com.onemount.cinema.model.OrderLine;
import com.onemount.cinema.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {

    @Autowired
    OrderLineRepository orderLineRepository;

//    public OrderLine createOrderLine(){
//
//    }
}
