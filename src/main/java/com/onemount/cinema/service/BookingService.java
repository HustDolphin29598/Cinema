package com.onemount.cinema.service;

import com.onemount.cinema.model.Booking;
import com.onemount.cinema.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getAllByEventId(int eventId){
        return bookingRepository.findByEvent_Id(eventId);
    }

    public Booking getById(int id){
        return bookingRepository.findById(id);
    }
}
