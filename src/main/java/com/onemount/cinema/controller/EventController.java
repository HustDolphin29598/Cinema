package com.onemount.cinema.controller;

import com.onemount.cinema.model.Event;
import com.onemount.cinema.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping(value = "", params = "filmId")
    public List<Event> getEventByFilmId(@RequestParam int filmId){
        return eventService.getAllByFilmId(filmId);
    }

    @GetMapping(value = "", params = "id")
    public Event getEventById(@RequestParam int id){
        return eventService.getById(id);
    }
}
