package com.onemount.cinema;

import com.onemount.cinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired private FilmService filmService;

    @Override
    public void run(String... args) throws Exception {
        filmService.generateFilm();
    }

}
