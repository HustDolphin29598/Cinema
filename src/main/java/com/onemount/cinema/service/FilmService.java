package com.onemount.cinema.service;

import com.onemount.cinema.enums.FilmStatus;
import com.onemount.cinema.model.Actor;
import com.onemount.cinema.model.Film;
import com.onemount.cinema.model.Genre;
import com.onemount.cinema.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;


    public List<Film> getALl(){
        return filmRepository.findAll();
    }
}
