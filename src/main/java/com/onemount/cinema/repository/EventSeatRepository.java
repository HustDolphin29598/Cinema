package com.onemount.cinema.repository;

import com.onemount.cinema.model.EventSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventSeatRepository extends JpaRepository<EventSeat, Integer> {
    EventSeat findById(int id);

    List<EventSeat> findByEvent_Id(int eventId);
}
