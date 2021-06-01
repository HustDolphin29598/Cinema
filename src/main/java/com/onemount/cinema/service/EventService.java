package com.onemount.cinema.service;

import com.onemount.cinema.model.Event;
import com.onemount.cinema.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public List<Event> getAllByFilmId(int filmId){
        return eventRepository.getAllByFilm_Id(filmId);
    }

    public Event getById(int id){
        return eventRepository.findById(id);
    }
}
