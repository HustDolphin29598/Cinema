package com.onemount.cinema.repository;

import com.onemount.cinema.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    Event findById(int id);

    List<Event> getAllByFilm_Id(int filmId);

}
