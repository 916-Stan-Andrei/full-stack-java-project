package com.example.lab2.repository;

import com.example.lab2.model.InsuranceCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<InsuranceCompany, Integer> {
}
