package com.example.lab2.service;

import com.example.lab2.model.Car;
import com.example.lab2.model.CarDTO;
import com.example.lab2.model.CarDTOMapper;
import com.example.lab2.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepo repository;
    @Autowired
    private CarDTOMapper carDTOMapper;

    public void saveCar(Car car){
        repository.save(car);
    }

    public List<CarDTO> getCars(){
        return repository.findAll()
                .stream()
                .map(carDTOMapper)
                .collect(Collectors.toList());
    }

    public CarDTO getCarById(int id){
        return repository.findById(id).map(carDTOMapper).orElse(null);
    }

    public void deleteCar(int id){
        repository.deleteById(id);
    }

    public Car updateCar(Car car){
        Car existingCar = repository.findById(car.getId()).orElse(null);
        existingCar.setModel(car.getModel());
        existingCar.setColor(car.getColor());
        existingCar.setBrand(car.getBrand());
        existingCar.setCylinderCapacity(car.getCylinderCapacity());
        existingCar.setMaxSpeed(car.getMaxSpeed());
        existingCar.setContracts(car.getContracts());
        return repository.save(existingCar);
    }

    public List<Car> getCarsWithMaxSpeedHigherThanGivenSpeed(int speed){
        List<Car> highSpeedCarList = new ArrayList<>();
        for (Car car:repository.findAll())
            if (car.getMaxSpeed() > speed) {
                highSpeedCarList.add(car);
            }
        return highSpeedCarList;
    }
}
