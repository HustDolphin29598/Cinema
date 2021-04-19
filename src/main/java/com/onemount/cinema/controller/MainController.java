package com.onemount.cinema.controller;

import com.onemount.cinema.model.Actor;
import com.onemount.cinema.model.Cinema;
import com.onemount.cinema.repository.ActorRepository;
import com.onemount.cinema.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    ActorRepository actorRepository;

    @GetMapping("/test")
    public List<Actor> getALlCinemas(){
        return actorRepository.findAll();
    }
}
