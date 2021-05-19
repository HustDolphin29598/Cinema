package com.onemount.cinema;

import com.onemount.cinema.service.FilmService;
import com.onemount.cinema.service.GenerateDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired private GenerateDataService generateDataService;

    @Override
    public void run(String... args) throws Exception {
        generateDataService.generateSampleData();
    }

}
