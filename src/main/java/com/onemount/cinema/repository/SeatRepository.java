package com.onemount.cinema.repository;

import com.onemount.cinema.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

    Seat findById(int id);

    List<Seat> findByRoom_Id(int roomId);
}
