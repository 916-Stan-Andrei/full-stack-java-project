package com.example.lab2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CAR_TABLE")
public class Car{
    @Id
    @GeneratedValue
    private int id;

    private String brand;
    private String model;
    private String color;
    private float cylinderCapacity;
    private int maxSpeed;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;
}

