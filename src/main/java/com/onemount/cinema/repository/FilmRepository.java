package com.onemount.cinema.repository;

import com.onemount.cinema.model.Film;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    Film findById(int id);

}
