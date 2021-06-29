package com.onemount.cinema.controller;

import com.onemount.cinema.model.Event;
import com.onemount.cinema.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/date/{showingDate}")
    public List<Event> getEventByShowingDate(@PathVariable String showingDate){
        return eventService.getAllByShowingDate(showingDate);
    }

    @GetMapping("/city/{city}")
    public List<Event> getEventByCity(@PathVariable String city){
        return eventService.getAllByCity(city);
    }

    @GetMapping("/city/{city}/date/{showingDate}")
    public List<Event> getEventByCity(@PathVariable String city, @PathVariable String showingDate){
        return eventService.getAllByCityAndShowingDate(city, showingDate);
    }

}
