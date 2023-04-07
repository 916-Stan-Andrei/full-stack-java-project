package com.example.lab2.service;

import com.example.lab2.model.*;
import com.example.lab2.repository.HouseRepo;
import com.example.lab2.repository.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class OwnerHouseDTO {
    @Autowired
    private HouseRepo houseRepo;
    @Autowired
    private OwnerRepo ownerRepo;

    @Autowired
    private OwnerDTOMapper ownerDTOMapper;

    public List<OwnerDTO> getOwnersOrderedByAverageSurfaceOfHouses(){
        int sum;
        float houseNb;
        for(Owner owner : ownerRepo.findAll() ) {
            sum = 0;
            houseNb = 0;
            for (House house : houseRepo.findAll())
                if (owner.getId() == house.getOwner().getId()) {
                    sum += house.getSurface();
                    houseNb += 1.0;
                }
            owner.setAverageHouseSurface(sum/houseNb);
            ownerRepo.save(owner);
        }

        return ownerRepo.findAll()
                .stream()
                .sorted(Comparator.comparing(Owner::getAverageHouseSurface))
                .map(ownerDTOMapper).toList();
    }

}
