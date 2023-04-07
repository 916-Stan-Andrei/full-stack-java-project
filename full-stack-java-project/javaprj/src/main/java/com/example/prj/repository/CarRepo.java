package com.example.lab2.repository;

import com.example.lab2.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepo extends JpaRepository<Car, Integer> {
}
