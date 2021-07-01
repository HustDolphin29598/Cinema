package com.onemount.cinema.controller;

import com.onemount.cinema.model.Booking;
import com.onemount.cinema.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping(value = "", params = "eventId")
    public List<Booking> getBookingByEventId(@RequestParam int eventId){
        List<Booking> bookingList = bookingService.getAllByEventId(eventId);
        Collections.sort(bookingList, new Comparator<Booking>() {
            @Override
            public int compare(Booking booking1, Booking booking2) {
                if(!booking1.getSeat().getRow().equals(booking2.getSeat().getRow())){
                    return booking1.getSeat().getRow().compareTo(booking2.getSeat().getRow());
                }else{
                    return booking1.getSeat().getColumn() - booking2.getSeat().getColumn();
                }
            }
        });
        return bookingList;
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
