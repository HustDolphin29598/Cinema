package com.onemount.cinema.controller;

import com.onemount.cinema.request.OrderLineRequest;
import com.onemount.cinema.response.BasicResponse;
import com.onemount.cinema.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class OrderLineController {

    @Autowired
    OrderLineService orderLineService;

    @PostMapping("")
    public ResponseEntity<BasicResponse> createOrderLine(@RequestBody OrderLineRequest request){
        orderLineService.createOrderLine(request);
        return ResponseEntity.ok(new BasicResponse("Orderline added to list !"));
    }
}
