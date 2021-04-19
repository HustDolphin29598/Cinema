package com.onemount.cinema.repository;

import com.onemount.cinema.model.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
}
