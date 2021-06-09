package com.onemount.cinema.controller;

import com.onemount.cinema.model.OrderLine;
import com.onemount.cinema.request.OrderLineRequest;
import com.onemount.cinema.response.BasicResponse;
import com.onemount.cinema.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderline")
public class OrderLineController {

    @Autowired
    OrderLineService orderLineService;

    @PostMapping("/create")
    public ResponseEntity<BasicResponse> createOrderLine(@RequestBody OrderLineRequest request){
        orderLineService.createOrderLine(request);
        return ResponseEntity.ok(new BasicResponse("Orderline added to list !"));
    }

    @GetMapping(value = "", params = "id")
    public OrderLine getOrderLineById(@RequestParam int id){
        return orderLineService.findById(id);
    }

    @GetMapping(value = "", params = "orderId")
    public List<OrderLine> getOrderLineByOrderId(@RequestParam int orderId){
        return orderLineService.findByOrderId(orderId);
    }
}
