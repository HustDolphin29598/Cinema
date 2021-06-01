package com.onemount.cinema.controller;

import com.onemount.cinema.model.EventSeat;
import com.onemount.cinema.service.EventSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eventseat")
public class EventSeatController {

    @Autowired
    EventSeatService eventSeatService;

    @GetMapping(value = "", params = "eventId")
    public List<EventSeat> getAllByEventId(@RequestParam int eventId){
        return eventSeatService.getAllByEventId(eventId);
    }

    @GetMapping(value = "", params = "id")
    public EventSeat getById(@RequestParam int id){
        return eventSeatService.getById(id);
    }
}
