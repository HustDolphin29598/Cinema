package com.onemount.cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity(name = "genre")
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<FilmGenre> filmGenres = new ArrayList<>();

    public Genre(String name, String description){
        this.name = name;
        this.description = description;
    }
}
