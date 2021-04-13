package com.onemount.cinema.model;

import com.onemount.cinema.enums.FilmStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    private int id;
    private String title;
    private String description;
    private String thumbnail;
    private int runningTime;
    private Date releaseDate;
    private FilmStatus status;
}
