package com.onemount.cinema.schedule;

import com.onemount.cinema.enums.EventSeatStatus;
import com.onemount.cinema.enums.OrderStatus;
import com.onemount.cinema.model.EventSeat;
import com.onemount.cinema.model.Order;
import com.onemount.cinema.model.OrderLine;
import com.onemount.cinema.model.Time;
import com.onemount.cinema.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
@ConditionalOnExpression("true")
public class UpdateTimeoutSchedule {

    @Autowired
    OrderService orderService;

    private static final long timeoutDuration = 1000 * 20;

    @Scheduled(fixedRate = 5000)
    public void scheduleFixedRate() throws InterruptedException {
        List<Order> createdStatusOrder = orderService.getCreatedStatusOrders();
        for(Order order: createdStatusOrder){
            long duration = new Date().getTime() - order.getTime().getUpdatedAt().getTime();
            if(duration >= timeoutDuration){
                order.setOrderStatus(OrderStatus.TIMEOUT);
                for(OrderLine orderLine: order.getOrderLineList()){
                    EventSeat eventSeat = orderLine.getEventSeat();
                    eventSeat.setStatus(EventSeatStatus.AVAILABLE);
                }
                order.getTime().setUpdatedAt(new Date());
                orderService.save(order);
            }
        }
    }
}