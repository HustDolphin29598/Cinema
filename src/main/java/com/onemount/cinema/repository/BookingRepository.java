package com.onemount.cinema.repository;

import com.onemount.cinema.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking findById(int id);

    List<Booking> findByEvent_Id(int eventId);
}
