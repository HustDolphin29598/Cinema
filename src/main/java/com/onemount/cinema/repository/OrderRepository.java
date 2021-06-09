package com.onemount.cinema.repository;

import com.onemount.cinema.enums.OrderStatus;
import com.onemount.cinema.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findById(int id);

    List<Order> findByOrderStatus(OrderStatus status);

    List<Order> findByCustomerId(int customerId);
}
