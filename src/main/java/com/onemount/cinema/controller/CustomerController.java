package com.onemount.cinema.controller;

import com.onemount.cinema.model.Customer;
import com.onemount.cinema.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public List<Customer> getAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GetMapping(value = "", params = "id")
    public Customer getCustomerById(@RequestParam int id){
        return customerService.findById(id);
    }
}
