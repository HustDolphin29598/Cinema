package com.onemount.cinema.repository;

import com.onemount.cinema.model.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CinemaRepository {

    private ArrayList<Cinema> cinemas;

    @Autowired
    public CinemaRepository(StaffRepository staffRepository){
    }

    public List<Cinema> getAllCinemas(){
        return cinemas;
    }
}
