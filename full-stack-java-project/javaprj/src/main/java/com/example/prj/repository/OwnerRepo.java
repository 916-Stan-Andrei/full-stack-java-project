package com.example.lab2.repository;

import com.example.lab2.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepo extends JpaRepository<Owner, Integer> {
}
