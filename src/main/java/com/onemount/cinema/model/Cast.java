package com.onemount.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity(name = "cast")
@Table(name = "cast")
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "actor_id")
    private int actorId;

    @Column(name = "film_id")
    private int filmId;
}
