package com.onemount.cinema.service;

import com.github.javafaker.Faker;
import com.onemount.cinema.enums.EventStatus;
import com.onemount.cinema.enums.FilmStatus;
import com.onemount.cinema.model.*;
import com.onemount.cinema.repository.CinemaRepository;
import com.onemount.cinema.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenerateDataService {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    private final Faker faker = new Faker();


    @Transactional
    public void generateSampleData() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Film film1 = new Film();
        Film film2 = new Film();
        Actor actor1 = new Actor("Daniel Radcliffe", 31, "United Kingdom");
        Actor actor2 = new Actor("Rupert Grint", 32, "United Kingdom");
        Actor actor3 = new Actor("Emma Watson", 31, "United Kingdom");
        Actor actor4 = new Actor("Alan Rickman", "United Kingdom");
        Genre adventure = new Genre("Adventure","");
        Genre comedy = new Genre("Comedy","");
        Genre cartoon = new Genre("Cartoon","");
        Genre fiction = new Genre("Fiction","");
        Genre fantastic = new Genre("Fantastic","");
        List<Actor> actors1 = new ArrayList<>();
        actors1.add(actor1);
        actors1.add(actor2);
        actors1.add(actor3);
        actors1.add(actor4);
        film1.setActors(actors1);
        film1.addGenre(adventure);
        film1.addGenre(fiction);
        film1.addGenre(fantastic);
        film1.setDescription("Without the guidance and protection of their professors, Harry (Daniel Radcliffe), Ron (Rupert Grint) and Hermione (Emma Watson) begin a mission to destroy the Horcruxes, the sources of Voldemort's immortality.");
        film1.setRunningTime(120);
        film1.setTitle("Harry Potter and the deathly hallows");
        film1.setReleaseDate(formatter.parse("10/05/2021"));
        film1.setStatus(FilmStatus.ON_THEATER);

        filmRepository.save(film1);

        Actor actor5 = new Actor("Wasabi Mizuta", "Japan");
        Actor actor6 = new Actor("Megumi Oohara", "Japan");
        Actor actor7 = new Actor("Subaru Kimura", "Japan");
        Actor actor8 = new Actor("Yumi Kakazu", "Japan");

        List<Actor> actors2 = new ArrayList<>();
        actors2.add(actor5);
        actors2.add(actor6);
        actors2.add(actor7);
        actors2.add(actor8);
        film2.setActors(actors2);
        film2.addGenre(comedy);
        film2.addGenre(cartoon);
        film2.setDescription("Nobita - following his previous adventure - has managed to change his future for the better, making Shizuka marry him. Taken by despair, however, he decides to return to the past to re-meet his beloved grandmother, she died when he was still in kindergarten and to whom he was really fond of; grandmother is happy that Nobita came back in time to be with her, and confides in him a great desire: to meet his future bride");
        film2.setRunningTime(150);
        film2.setTitle("DORAEMON: STAND BY ME 2");
        film2.setReleaseDate(formatter.parse("05/07/2021"));
        film2.setStatus(FilmStatus.INCOMING);

        filmRepository.save(film2);

        Cinema cinema1 = new Cinema("CGV Ba Trieu", "40 Ba Trieu, Ha Noi");
//        Cinema cinema2 = new Cinema("CGV Kim Ma", "120 Kim Ma, Ha Noi");
        generateCinemaAndEvent(cinema1, film1);
//        generateCinemaAndEvent(cinema2, film2);

    }

    @Transactional
    public void generateCinemaAndEvent(Cinema cinema, Film film) throws ParseException {
        List<Staff> staffList = new ArrayList<>();
        List<Room> roomList = new ArrayList<>();
        for(int i=0; i<30;i++){
            Staff staff = new Staff(faker.name().fullName(), faker.code().asin(),faker.number().numberBetween(18,30));
            staffList.add(staff);
        }

        Room room1 = new Room("A");
        room1 = generateSeatAndEvent(room1, film);
        Room room2 = new Room("B");
//        room2 = generateSeatAndEvent(room2, film);

        roomList.add(room1);
        roomList.add(room2);

        cinema.setStaffs(staffList);
        cinema.setRooms(roomList);

        cinemaRepository.save(cinema);

    }

    @Transactional
    public Room generateSeatAndEvent(Room room, Film film) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        List<Seat> roomSeat = new ArrayList<>();
        List<Event> events = new ArrayList<>();
        String[] rowList = {"A", "B", "C"};
        for (String row: rowList) {
            for (int i=0;i<5;i++){
                Seat seat = new Seat(row,i);

                Event event = new Event();
                event.setStartTime(formatter.parse("20/05/2021 19:00:00"));
                event.setEndTime(formatter.parse("20/05/2021 21:00:00"));
                event.setStatus(EventStatus.AVAILABLE);
                event.setPrice(faker.number().numberBetween(50000, 200000));
                event.setSeat(seat);

                events.add(event);
                roomSeat.add(seat);
            }
        }
        film.setEvents(events);
        filmRepository.save(film);
        room.setSeats(roomSeat);
        return room;
    }
}
