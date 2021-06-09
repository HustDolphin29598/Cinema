package com.onemount.cinema.controller;

import com.onemount.cinema.model.Order;
import com.onemount.cinema.request.OrderRequest;
import com.onemount.cinema.response.BasicResponse;
import com.onemount.cinema.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("")
    public ResponseEntity<BasicResponse> createOrder(@RequestBody OrderRequest request){
        orderService.order(request);
        return ResponseEntity.ok(new BasicResponse("Order created successful !"));
    }

    @GetMapping(value = "", params = "id")
    public Order getOrderById(int id){
        return orderService.findById(id);
    }

    @GetMapping(value = "", params = "customerId")
    public List<Order> getOrderByCustomerId(int customerId){
        return orderService.findByCustomerId(customerId);
    }
}
