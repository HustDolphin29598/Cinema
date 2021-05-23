package com.onemount.cinema.service;

import com.onemount.cinema.enums.EventSeatStatus;
import com.onemount.cinema.enums.OrderLineStatus;
import com.onemount.cinema.exception.LogicException;
import com.onemount.cinema.exception.NotFoundException;
import com.onemount.cinema.model.Customer;
import com.onemount.cinema.model.EventSeat;
import com.onemount.cinema.model.OrderLine;
import com.onemount.cinema.model.Time;
import com.onemount.cinema.repository.CustomerRepository;
import com.onemount.cinema.repository.EventSeatRepository;
import com.onemount.cinema.repository.OrderLineRepository;
import com.onemount.cinema.request.OrderLineRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class OrderLineService {

    @Autowired
    OrderLineRepository orderLineRepository;

    @Autowired
    EventSeatRepository eventSeatRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public OrderLine createOrderLine(OrderLineRequest request){

        int eventSeatId = request.getEventSeatId();
        int customerId = request.getCustomerId();

        if (eventSeatId == 0 || customerId == 0){
            throw new LogicException ("EventSeat ID or Customer ID must be positive !");
        }

        Customer customer = customerRepository.findById(customerId);
        EventSeat eventSeat = eventSeatRepository.findById(eventSeatId);
        if(customer == null){
            throw new NotFoundException(customerId + " is not found", "Customer");
        }
        if( eventSeat == null){
            throw new NotFoundException(eventSeatId + " is not found", "EventSeat");

        }
        OrderLine orderLine = OrderLine.builder()
                .time(new Time(new Date(), new Date()))
                .customer(customer)
                .eventSeat(eventSeat)
                .build();

        EventSeatStatus eventSeatStatus = eventSeat.getStatus();
        if(eventSeatStatus == EventSeatStatus.IN_PROCESS || eventSeatStatus == EventSeatStatus.RESERVED){
            throw new LogicException("EventSeat is already reserved or in processing !");
        }

        orderLineRepository.save(orderLine);
        return orderLine;

    }
}
