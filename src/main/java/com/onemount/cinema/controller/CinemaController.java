package com.onemount.cinema.controller;

import com.onemount.cinema.model.Cinema;
import com.onemount.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

    @GetMapping("")
    public List<Cinema> getAll(){
        return cinemaService.getAll();
    }

    @GetMapping(value = "", params = "city")
    public List<Cinema> getAllByCity(@RequestParam String city){
        return cinemaService.getAllByCity(city);
    }

    @GetMapping(value = "", params = "id")
    public Cinema getByFilmId(@RequestParam int id){
        return cinemaService.getById(id);
    }
}
