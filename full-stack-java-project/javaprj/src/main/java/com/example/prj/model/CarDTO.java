package com.example.lab2.model;

public record CarDTO(
    int id,
    String brand,
    String model,
    String color,
    float cylinderCapacity,
    int maxSpeed,
    int owner_id
) {

}
