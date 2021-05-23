package com.onemount.cinema.repository;

import com.onemount.cinema.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    OrderLine findById(int id);
}
