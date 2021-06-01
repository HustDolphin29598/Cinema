package com.onemount.cinema.service;

import com.onemount.cinema.model.Seat;
import com.onemount.cinema.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    SeatRepository seatRepository;

    public Seat getById(int id){
        return seatRepository.findById(id);
    }

    public List<Seat> getAllByRoomId(int roomId){
        return seatRepository.findByRoom_Id(roomId);
    }
}
