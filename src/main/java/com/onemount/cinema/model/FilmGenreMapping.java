package com.onemount.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FilmGenreMapping {
    private int filmId;
    private int genreId;
}
