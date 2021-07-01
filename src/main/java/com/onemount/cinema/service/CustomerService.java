package com.onemount.cinema.service;

import com.onemount.cinema.enums.CustomerType;
import com.onemount.cinema.model.Customer;
import com.onemount.cinema.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer findById(int id){
        return customerRepository.findById(id);
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer createCustomer(String fullName, String password, String address, String phone, String email,  int point, CustomerType type){
        Customer customer = new Customer(fullName, password, address, phone, email,  point, type);
        customerRepository.save(customer);
        return customer;
    }
}
