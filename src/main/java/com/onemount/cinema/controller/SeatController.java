package com.onemount.cinema.controller;

import com.onemount.cinema.model.Seat;
import com.onemount.cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    SeatService seatService;

    @GetMapping(value = "", params = "id")
    public Seat getSeatById(@RequestParam int id){
        return seatService.getById(id);
    }

    @GetMapping(value = "", params = "roomId")
    public List<Seat> getSeatByRoomId(@RequestParam int roomId){
        return seatService.getAllByRoomId(roomId);
    }
}
