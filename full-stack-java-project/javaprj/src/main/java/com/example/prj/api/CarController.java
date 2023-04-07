package com.example.lab2.api;

import com.example.lab2.model.Car;
import com.example.lab2.model.CarDTO;
import com.example.lab2.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/addCar")
    public void addCar(@RequestBody Car car){
        carService.saveCar(car);
    }

    @GetMapping("/cars")
    public List<CarDTO> getAllCars(){
        return carService.getCars();
    }

    @GetMapping("/car/{id}")
    public CarDTO getCarById(@PathVariable int id){
        return carService.getCarById(id);
    }

    @DeleteMapping("/deleteCar/{id}")
    public void removeCar(@PathVariable int id){
        carService.deleteCar(id);
    }

    @PutMapping("/updateCar")
    public Car updateCar(@RequestBody Car car){return carService.updateCar(car);}

    @GetMapping("/higher/{speed}")
    public List<Car> getCarsWithMaxSpeedHigherThanGivenSpeed(@PathVariable int speed){return carService.getCarsWithMaxSpeedHigherThanGivenSpeed(speed);}
}
