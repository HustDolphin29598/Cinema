package com.onemount.cinema.request;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    List<Integer> orderLineRequestId;
}
