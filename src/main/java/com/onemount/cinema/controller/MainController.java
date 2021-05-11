package com.onemount.cinema.controller;

import com.onemount.cinema.model.Actor;
import com.onemount.cinema.model.Cinema;
import com.onemount.cinema.model.Film;
import com.onemount.cinema.repository.ActorRepository;
import com.onemount.cinema.repository.CinemaRepository;
import com.onemount.cinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("")
public class MainController {

    @Autowired
    FilmService filmService;

    @GetMapping("/films")
    public List<Film> getAllFilms(){
        return filmService.getALl();
    }
}
