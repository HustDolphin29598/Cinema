package com.onemount.cinema.repository;

import com.onemount.cinema.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    Event findById(int id);

    List<Event> getAllByFilm_Id(int filmId);

    List<Event> getAllByStartTime(LocalTime startTime);

    List<Event> getAllByShowingDateAndFilm_Id(LocalDate showingDate, int filmId);

    @Query("SELECT e from event e\n" +
            "LEFT JOIN room r \n" +
            "ON r.id = e.room.id\n" +
            "LEFT JOIN cinema c\n" +
            "ON r.cinema.id = c.id\n" +
            "WHERE c.city = ?1 and e.film.id = ?2")
    List<Event> getAllByCity(String city, int filmId);

    @Query("SELECT e from event e\n" +
            "LEFT JOIN room r \n" +
            "ON r.id = e.room.id\n" +
            "LEFT JOIN cinema c\n" +
            "ON r.cinema.id = c.id\n" +
            "WHERE c.city = ?1 and e.showingDate  = ?2 and e.film.id = ?3")
    List<Event> getAllByCityAndShowingDate(String city, LocalDate showingDate, int filmId);
}
