package com.example.lab2.repository;

import com.example.lab2.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepo extends JpaRepository<Contract, Integer> {
}
