package com.onemount.cinema.controller;

import com.onemount.cinema.model.Room;
import com.onemount.cinema.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping(value = "", params = "cinemaId")
    public List<Room> getRoomByCinemaId(@RequestParam int cinemaId){
        return roomService.getAllByCinemaId(cinemaId);
    }

    @GetMapping(value = "", params = "id")
    public Room getRoomById(@RequestParam int id){
        return roomService.getById(id);
    }
}
