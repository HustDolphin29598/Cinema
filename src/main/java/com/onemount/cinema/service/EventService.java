package com.onemount.cinema.service;

import com.onemount.cinema.model.Event;
import com.onemount.cinema.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
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

    public List<Event> getAllByStartingTime(String startingTimeStr){
        LocalTime startTime = LocalTime.parse(startingTimeStr);
        return eventRepository.getAllByStartTime(startTime);
    }

    public List<Event> getAllByShowingDate(String showingDateStr, int filmId){
        LocalDate showingDate = LocalDate.parse(showingDateStr);
        return eventRepository.getAllByShowingDateAndFilm_Id(showingDate, filmId);
    }

    public List<Event> getAllByCity(String city, int filmId){
        return eventRepository.getAllByCity(city, filmId);
    }

    public List<Event> getAllByCityAndShowingDate(String city, String showingDateStr, int filmId){
        LocalDate showingDate = LocalDate.parse(showingDateStr);
        return eventRepository.getAllByCityAndShowingDate(city, showingDate, filmId);
    }
}
