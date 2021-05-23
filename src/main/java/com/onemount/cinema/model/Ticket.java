package com.onemount.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "ticket")
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private OrderLine orderLine;

    private String code;

    @Embedded
    private Time time;

    public Ticket(String code) {
        this.code = code;
    }
}
