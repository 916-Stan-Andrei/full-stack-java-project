package com.example.lab2.service;

import com.example.lab2.model.Car;
import com.example.lab2.model.Owner;
import com.example.lab2.model.OwnerDTO;
import com.example.lab2.model.OwnerDTOMapper;
import com.example.lab2.repository.CarRepo;
import com.example.lab2.repository.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class OwnerCarDTO {
    @Autowired
    private OwnerRepo ownerRepo;

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private OwnerDTOMapper ownerDTOMapper;

    public List<OwnerDTO> getOwnersOrderedByFastestCar(){
        int max;
        for(Owner owner : ownerRepo.findAll()){
            max = -1;
            for (Car car : carRepo.findAll())
                if(owner.getId() == car.getOwner().getId() && car.getMaxSpeed() > max)
                    max = car.getMaxSpeed();
            owner.setBestCarMaxSpeed(max);
            ownerRepo.save(owner);
        }
        return ownerRepo.findAll()
                .stream()
                .sorted(Comparator.comparing(Owner::getBestCarMaxSpeed ))
                .map(ownerDTOMapper).toList();
    }
}
