package com.onemount.cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.onemount.cinema.enums.FilmStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "film")
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String thumbnail;

    @Column(name = "running_time")
    private int runningTime;

    @Column(name = "release_date")
    private Date releaseDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private FilmStatus status;

    @ManyToMany(mappedBy = "films")
    @JsonBackReference
    private Set<Actor> actors;
}
