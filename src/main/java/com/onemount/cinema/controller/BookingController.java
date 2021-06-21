package com.onemount.cinema.controller;

import com.onemount.cinema.model.Booking;
import com.onemount.cinema.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/eventId/{eventId}/seatId/{seatId}")
    public ResponseEntity<Booking> getBookingByEventIdAndSeat(@PathVariable int eventId, @PathVariable int seatId){
        Booking booking = bookingService.getByEventIdAndSeatId(eventId, seatId);
        if(booking == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(booking);
    }

    @GetMapping(value = "", params = "id")
    public Booking getBookingById(@RequestParam int id){
        return bookingService.getById(id);
    }
}
