package com.example.lab2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contract_table")
public class Contract {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Car car;

    @ManyToOne
    private InsuranceCompany insuranceCompany;

    private int papersNb;
    private boolean isOfficial;
    private String deadline;
    private String signingDate;


}
