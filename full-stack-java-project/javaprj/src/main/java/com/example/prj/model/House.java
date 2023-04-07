package com.example.lab2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "house_table")
public class House {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    private int surface;
    private String address;
    private int floorsNb;
    private int roomsNb;
    private boolean garden;


}
