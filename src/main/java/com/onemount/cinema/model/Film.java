package com.onemount.cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onemount.cinema.enums.FilmStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
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

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
//    @JsonManagedReference
    @JsonIgnore
    private List<Cast> casts = new ArrayList<>();

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
//    @JsonManagedReference
    @JsonIgnore
    private List<FilmGenre> filmGenres = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id")
//    @JsonManagedReference
    @JsonIgnore
    private List<Event> events = new ArrayList<>();

    @JsonGetter(value = "actors")
    @Transient
    public List<String> getActors() {
        List<String> result = new ArrayList<>();
        casts.stream().forEach(cast -> result.add(cast.getActor().getName()));
        return result;
    }

    @JsonGetter(value = "genres")
    @Transient
    public List<String> getGenres() {
        List<String> result = new ArrayList<>();
        filmGenres.stream().forEach(filmGenre -> result.add(filmGenre.getGenre().getName()));
        return result;
    }

    public Film(String title, String description, String thumbnail, int runningTime, Date releaseDate, FilmStatus status, List<Event> events) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.runningTime = runningTime;
        this.releaseDate = releaseDate;
        this.status = status;
        this.events = events;
    }
}
