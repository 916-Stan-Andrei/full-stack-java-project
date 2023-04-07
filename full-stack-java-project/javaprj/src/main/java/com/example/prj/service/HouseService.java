package com.example.lab2.service;

import com.example.lab2.model.House;
import com.example.lab2.model.HouseDTO;
import com.example.lab2.model.HouseDTOMapper;
import com.example.lab2.repository.HouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseService {
    @Autowired
    private HouseRepo repository;

    @Autowired
    private HouseDTOMapper houseDTOMapper;

    public void saveHouse(House house){ repository.save(house);}

    public List<HouseDTO> getAllHouses(){
        return repository.findAll()
                .stream()
                .map(houseDTOMapper)
                .collect(Collectors.toList());
    }

    public HouseDTO getHouse(int id){return repository.findById(id).map(houseDTOMapper).orElse(null);}

    public void deleteHouse(int id){ repository.deleteById(id);}

    public House updateHouse(House newHouse){
        House existingHouse =  repository.findById(newHouse.getId()).orElse(null);
        existingHouse.setAddress(newHouse.getAddress());
        existingHouse.setSurface(newHouse.getSurface());
        existingHouse.setGarden(newHouse.isGarden());
        existingHouse.setRoomsNb(newHouse.getRoomsNb());
        existingHouse.setFloorsNb(newHouse.getFloorsNb());
        return repository.save(existingHouse);
    }

}
