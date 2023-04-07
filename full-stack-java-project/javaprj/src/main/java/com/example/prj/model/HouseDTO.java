package com.example.lab2.model;

public record HouseDTO(
        int id,
        int owner_id,
        int surface,
        String address,
        int floorsNb,
        int roomsNb,
        boolean garden
) {
}
