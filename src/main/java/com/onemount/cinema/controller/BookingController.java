package com.onemount.cinema.controller;

import com.onemount.cinema.model.Booking;
import com.onemount.cinema.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping(value = "", params = "eventId")
    public List<Booking> getBookingByEventId(@RequestParam int eventId){
        return bookingService.getAllByEventId(eventId);
    }

    @GetMapping(value = "", params = "id")
    public Booking getBookingById(@RequestParam int id){
        return bookingService.getById(id);
    }
}
