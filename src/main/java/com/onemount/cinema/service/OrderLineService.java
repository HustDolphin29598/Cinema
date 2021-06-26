package com.onemount.cinema.service;

import com.onemount.cinema.enums.BookingStatus;
import com.onemount.cinema.exception.LogicException;
import com.onemount.cinema.exception.NotFoundException;
import com.onemount.cinema.model.Customer;
import com.onemount.cinema.model.Booking;
import com.onemount.cinema.model.OrderLine;
import com.onemount.cinema.model.Time;
import com.onemount.cinema.repository.CustomerRepository;
import com.onemount.cinema.repository.BookingRepository;
import com.onemount.cinema.repository.OrderLineRepository;
import com.onemount.cinema.request.OrderLineListRequest;
import com.onemount.cinema.request.OrderLineRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderLineService {

    @Autowired
    OrderLineRepository orderLineRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public OrderLine createOrderLine(OrderLineRequest request){

        int bookingId = request.getBookingId();
        int customerId = request.getCustomerId();

        if (bookingId == 0 || customerId == 0){
            throw new LogicException ("Booking ID or Customer ID must be positive !");
        }

        Customer customer = customerRepository.findById(customerId);
        Booking booking = bookingRepository.findById(bookingId);
        if(customer == null){
            throw new NotFoundException(customerId + " is not found", "Customer");
        }
        if( booking == null){
            throw new NotFoundException(bookingId + " is not found", "Booking");

        }
        OrderLine orderLine = OrderLine.builder()
                .time(new Time(new Date(), new Date()))
                .customer(customer)
                .booking(booking)
                .build();

        BookingStatus bookingStatus = booking.getStatus();
        if(bookingStatus == BookingStatus.IN_PROCESS || bookingStatus == BookingStatus.RESERVED){
            throw new LogicException("Booking is already reserved or in processing !");
        }

        orderLineRepository.save(orderLine);
        return orderLine;

    }

    @Transactional
    public List<OrderLine> createOrderLineList(OrderLineListRequest request){
        int customerId = request.getCustomerId();
        List<Integer> bookingIds = request.getBookingId();
        List<OrderLine> orderLineList = new ArrayList<>();
        for(Integer bookingId: bookingIds){
            OrderLineRequest orderLineRequest = new OrderLineRequest(customerId, bookingId);
            OrderLine orderLine = createOrderLine(orderLineRequest);
            if(orderLine != null){
                orderLineList.add(orderLine);
            }
        }
        return orderLineList;
    }

    public OrderLine findById(int id){
        return orderLineRepository.findById(id);
    }

    public List<OrderLine> findByOrderId(int orderId){
        return orderLineRepository.findByOrderId(orderId);
    }
}
