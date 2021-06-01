package com.onemount.cinema.controller;

import com.onemount.cinema.model.Film;
import com.onemount.cinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    FilmService filmService;

    @GetMapping("")
    public List<Film> getAllFilms(){
        return filmService.getALl();
    }

    @GetMapping(value = "", params = "id")
    public Film getFilmById(@RequestParam int id){
        return filmService.getById(id);
    }
}
