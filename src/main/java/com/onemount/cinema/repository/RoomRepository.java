package com.onemount.cinema.repository;

import com.onemount.cinema.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    Room findById(int id);

    List<Room> findByCinema_Id(int cinemaId);
}
