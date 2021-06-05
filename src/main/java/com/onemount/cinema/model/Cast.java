package com.onemount.cinema.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "cast")
@Table(name = "cast")
@Data
@NoArgsConstructor
public class Cast {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id")
    private Film film;

    public Cast(Actor actor, Film film){
        this.actor = actor;
        this.film = film;
    }
}
