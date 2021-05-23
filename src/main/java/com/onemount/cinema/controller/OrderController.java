package com.onemount.cinema.controller;

import com.onemount.cinema.request.OrderRequest;
import com.onemount.cinema.response.BasicResponse;
import com.onemount.cinema.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("")
    public ResponseEntity<BasicResponse> order(@RequestBody OrderRequest request){
        orderService.order(request);
        return ResponseEntity.ok(new BasicResponse("Order created successful !"));
    }
}
