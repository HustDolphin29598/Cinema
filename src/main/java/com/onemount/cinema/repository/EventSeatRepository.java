package com.onemount.cinema.repository;

import com.onemount.cinema.model.EventSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventSeatRepository extends JpaRepository<EventSeat, Integer> {
}
