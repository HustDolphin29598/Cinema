package com.onemount.cinema.controller;

import com.onemount.cinema.model.Film;
import com.onemount.cinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
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

//    @PostMapping(value = "create")
//    public Film createNewFilm(){
//
//    }
}
