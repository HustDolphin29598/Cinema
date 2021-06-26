package com.onemount.cinema.schedule;

import com.onemount.cinema.enums.BookingStatus;
import com.onemount.cinema.enums.OrderStatus;
import com.onemount.cinema.model.Booking;
import com.onemount.cinema.model.Order;
import com.onemount.cinema.model.OrderLine;
import com.onemount.cinema.service.OrderLineService;
import com.onemount.cinema.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
@ConditionalOnExpression()
public class UpdateTimeoutSchedule {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderLineService orderLineService;

    private static final long timeoutDuration = 1000 * 60 * 10;

    @Scheduled(fixedRate = 5000)
    public void scheduleFixedRate() throws InterruptedException {
        List<Order> createdStatusOrder = orderService.getCreatedStatusOrders();
        for(Order order: createdStatusOrder){
            long duration = new Date().getTime() - order.getTime().getUpdatedAt().getTime();
            if(duration >= timeoutDuration){
                order.setOrderStatus(OrderStatus.TIMEOUT);
                for(OrderLine orderLine: orderLineService.findByOrderId(order.getId())){
                    Booking booking = orderLine.getBooking();
                    booking.setStatus(BookingStatus.AVAILABLE);
                }
                order.getTime().setUpdatedAt(new Date());
                orderService.save(order);
            }
        }
    }
}