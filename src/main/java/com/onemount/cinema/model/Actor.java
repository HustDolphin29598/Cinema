package com.onemount.cinema.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "actor")
@Table(name = "actor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Integer age;

    private String country;

    @ManyToMany(mappedBy = "actors", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Film> films;

}
