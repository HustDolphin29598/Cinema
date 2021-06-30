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

    @GetMapping("/date/{showingDate}/filmId/{filmId}")
    public List<Event> getEventByShowingDate(@PathVariable String showingDate, @PathVariable int filmId){
        return eventService.getAllByShowingDate(showingDate, filmId);
    }

    @GetMapping("/city/{city}/filmId/{filmId}")
    public List<Event> getEventByCity(@PathVariable String city, @PathVariable int filmId){
        return eventService.getAllByCity(city, filmId);
    }

    @GetMapping("/city/{city}/date/{showingDate}/filmId/{filmId}")
    public List<Event> getEventByCity(@PathVariable String city, @PathVariable String showingDate, @PathVariable int filmId){
        return eventService.getAllByCityAndShowingDate(city, showingDate, filmId);
    }

    @GetMapping("/city/{city}/date/{showingDate}/cinema/{cinemaName}/filmId/{filmId}")
    public List<Event> getEventByCity(@PathVariable String city, @PathVariable String showingDate, @PathVariable String cinemaName, @PathVariable int filmId){
        return eventService.getAllByCityAndShowingDateAndCinema(city, showingDate, filmId, cinemaName);
    }
}
