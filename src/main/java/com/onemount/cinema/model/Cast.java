package com.onemount.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Cast {
    private int id;
    private int actorId;
    private int FilmId;
}
