package com.onemount.cinema.service;

import com.onemount.cinema.model.Cinema;
import com.onemount.cinema.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    @Autowired
    CinemaRepository cinemaRepository;

    public List<Cinema> getAll(){
        return cinemaRepository.findAll();
    }

    public List<Cinema> getAllByCity(String city){
        return cinemaRepository.findByCity(city);
    }

    public Cinema getById(int id){
        return cinemaRepository.findById(id);
    }
}
