package com.onemount.cinema.service;

import com.onemount.cinema.model.Cinema;
import com.onemount.cinema.model.Room;
import com.onemount.cinema.model.Seat;
import com.onemount.cinema.repository.CinemaRepository;
import com.onemount.cinema.repository.RoomRepository;
import com.onemount.cinema.repository.SeatRepository;
import com.onemount.cinema.request.RoomRequest;
import com.onemount.cinema.request.SeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    public Room getById(int Id){
        return roomRepository.findById(Id);
    }

    public List<Room> getAllByCinemaId(int cinemaId){
        return roomRepository.findByCinema_Id(cinemaId);
    }

    public Room createRoom(RoomRequest roomRequest){
        if(roomRequest == null)
            return null;
        Cinema cinema = cinemaRepository.findById(roomRequest.getCinemaId());
        if(cinema == null)
            return null;
        Room room = new Room(roomRequest.getRoomName());
        room.setCinema(cinema);
        for(SeatRequest seatRequest: roomRequest.getSeats()){
            for(int i=0;i<seatRequest.getColNum();i++){
                Seat seat = new Seat(seatRequest.getRowName(),i);
                seat.setType(seatRequest.getSeatType());
                seat.setRoom(room);
                seatRepository.save(seat);
            }
        }

        return room;
    }
}
