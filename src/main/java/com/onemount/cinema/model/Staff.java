package com.onemount.cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "staff")
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;

    private String staffCode;

    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cinema_id")
    @JsonBackReference
    private Cinema cinema;

    public Staff(String fullName, String staffCode, int age){
        this.fullName = fullName;
        this.staffCode = staffCode;
        this.age = age;
    }
}
