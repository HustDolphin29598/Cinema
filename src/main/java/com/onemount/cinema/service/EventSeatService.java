package com.onemount.cinema.service;

import com.onemount.cinema.model.EventSeat;
import com.onemount.cinema.repository.EventSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventSeatService {

    @Autowired
    EventSeatRepository eventSeatRepository;

    public List<EventSeat> getAllByEventId(int eventId){
        return eventSeatRepository.findByEvent_Id(eventId);
    }

    public EventSeat getById(int id){
        return eventSeatRepository.findById(id);
    }
}
