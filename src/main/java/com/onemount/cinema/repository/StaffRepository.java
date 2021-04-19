package com.onemount.cinema.repository;

import com.onemount.cinema.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
