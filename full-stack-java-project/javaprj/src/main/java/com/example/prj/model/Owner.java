package com.example.lab2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owner_table")
public class Owner {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int ownedCarNb;
    private float height;
    private String job;
    private int howOld;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Car> cars;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<House> houses;

    @JsonIgnore
    private float averageHouseSurface;

    @JsonIgnore
    private int bestCarMaxSpeed;
}
