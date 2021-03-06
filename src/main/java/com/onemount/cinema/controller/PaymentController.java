package com.onemount.cinema.controller;

import com.onemount.cinema.request.OrderLineRequest;
import com.onemount.cinema.request.PayRequest;
import com.onemount.cinema.response.BasicResponse;
import com.onemount.cinema.service.OrderLineService;
import com.onemount.cinema.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PaymentController {

    @Autowired
    PayService payService;

    @PostMapping("")
    public ResponseEntity<BasicResponse> pay(@RequestBody PayRequest request){
        payService.pay(request);
        return ResponseEntity.ok(new BasicResponse("Payment is made successful !"));
    }
}
