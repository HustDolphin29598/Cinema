package com.onemount.cinema.service;

import com.onemount.cinema.model.Room;
import com.onemount.cinema.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public Room getById(int Id){
        return roomRepository.findById(Id);
    }

    public List<Room> getAllByCinemaId(int cinemaId){
        return roomRepository.findByCinema_Id(cinemaId);
    }
}
