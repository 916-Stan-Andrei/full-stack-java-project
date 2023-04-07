package com.example.lab2.model;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class HouseDTOMapper implements Function<House, HouseDTO> {
    @Override
    public HouseDTO apply(House house){
        return new HouseDTO(
                house.getId(),
                house.getOwner().getId(),
                house.getSurface(),
                house.getAddress(),
                house.getFloorsNb(),
                house.getRoomsNb(),
                house.isGarden()
        );
    }
}
