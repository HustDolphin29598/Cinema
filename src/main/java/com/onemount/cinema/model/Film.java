package com.onemount.cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cast",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    @JsonManagedReference
    private List<Actor> actors = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_genre",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @JsonManagedReference
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id")
    private List<Event> events = new ArrayList<>();

    public Film(String title, String description, String thumbnail, int runningTime, Date releaseDate, FilmStatus status, List<Actor> actors, List<Genre> genres, List<Event> events) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.runningTime = runningTime;
        this.releaseDate = releaseDate;
        this.status = status;
        this.actors = actors;
        this.genres = genres;
        this.events = events;
    }

    public void addActor(Actor actor){
        actors.add(actor);
        actor.getFilms().add(this);
    }

    public void addGenre(Genre genre){
        genres.add(genre);
        genre.getFilms().add(this);
    }
}
