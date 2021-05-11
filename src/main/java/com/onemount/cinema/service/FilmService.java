package com.onemount.cinema.service;

import com.onemount.cinema.model.Actor;
import com.onemount.cinema.model.Film;
import com.onemount.cinema.model.Genre;
import com.onemount.cinema.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Transactional
    public void generateFilm(){
        Film film1 = new Film();
        Film film2 = new Film();

        Actor actor1 = new Actor("Daniel Radcliffe", 31, "United Kingdom");
        Actor actor2 = new Actor("Rupert Grint", 32, "United Kingdom");
        Actor actor3 = new Actor("Emma Watson", 31, "United Kingdom");
        Actor actor4 = new Actor("Alan Rickman", "United Kingdom");
        Actor actor5 = new Actor();
        Actor actor6 = new Actor();
        Actor actor7 = new Actor();
        Actor actor8 = new Actor();

        Genre genre1 = new Genre("Adventure","");
        Genre genre2 = new Genre("Horror","");
        Genre genre3 = new Genre("Cartoon","");
        Genre genre4 = new Genre("Fiction","");

        film1.getActors().add(actor1);
        film1.getActors().add(actor2);
        film1.getActors().add(actor3);
        film1.getActors().add(actor4);
        film1.getGenres().add(genre1);
        film1.getGenres().add(genre2);

        filmRepository.save(film1);

    }

    public List<Film> getALl(){
        return filmRepository.findAll();
    }
}
