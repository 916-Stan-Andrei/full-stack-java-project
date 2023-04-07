package com.example.lab2.repository;

import com.example.lab2.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepo extends JpaRepository <House, Integer> {
}
