package com.onemount.cinema.repository;

import com.onemount.cinema.model.Staff;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StaffRepository {

    private ArrayList<Staff> staffs;

    public StaffRepository(){
    }

    public List<Staff> getStaff(){
        return staffs;
    }
}
