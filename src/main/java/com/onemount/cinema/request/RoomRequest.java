package com.onemount.cinema.request;

import lombok.Data;

import java.util.List;

@Data
public class RoomRequest {
    String roomName;
    int cinemaId;
    List<SeatRequest> seats;
}

