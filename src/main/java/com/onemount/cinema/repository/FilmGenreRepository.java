package com.onemount.cinema.repository;

import com.onemount.cinema.model.FilmGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmGenreRepository extends JpaRepository<FilmGenre, Integer> {
}
