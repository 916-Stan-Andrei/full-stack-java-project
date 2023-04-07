package com.example.lab2.model;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OwnerDTOMapper implements Function<Owner, OwnerDTO> {
    @Override
    public OwnerDTO apply(Owner owner) {
        return new OwnerDTO(
                owner.getId(),
                owner.getName(),
                owner.getOwnedCarNb(),
                owner.getHeight(),
                owner.getJob(),
                owner.getHowOld(),
                owner.getAverageHouseSurface(),
                owner.getBestCarMaxSpeed()
        );
    }
}
