package com.example.lab2.model;

public record OwnerDTO(
        int id,
        String name,
        int ownedCarNb,
        float height,
        String job,
        int howOld,
        float averageHouseSurface,
        int bestCarMaxSpeed
) {
}
