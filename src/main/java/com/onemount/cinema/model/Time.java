package com.onemount.cinema.model;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class Time {
    private Date startTime;

    private Date endTime;
}
