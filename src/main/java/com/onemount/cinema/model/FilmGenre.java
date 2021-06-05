package com.onemount.cinema.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "film_genre")
@Table(name = "film_genre")
@Data
@NoArgsConstructor
public class FilmGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id")
    private Film film;

    public FilmGenre(Genre genre, Film film) {
        this.genre = genre;
        this.film = film;
    }
}
