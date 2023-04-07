package com.example.lab2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "insurance_table")
public class InsuranceCompany {
    @Id
    @GeneratedValue
    private int id;

    private String companyName;
    private int budget;
    private String address;
    private int officesNb;
    private boolean international;

    @OneToMany(mappedBy = "insuranceCompany", cascade = CascadeType.ALL)
    private List<Contract> contracts;

}
