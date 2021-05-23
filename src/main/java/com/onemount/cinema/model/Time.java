package com.onemount.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Time {
    private Date createdAt;

    private Date updatedAt;
}
