package com.example.lab2.model;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CarDTOMapper implements Function<Car, CarDTO> {
    @Override
    public CarDTO apply(Car car){
        return new CarDTO(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getColor(),
                car.getCylinderCapacity(),
                car.getMaxSpeed(),
                car.getOwner().getId()
        );
    }
}
