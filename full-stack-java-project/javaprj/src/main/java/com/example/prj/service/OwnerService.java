package com.example.lab2.service;

import com.example.lab2.model.Owner;
import com.example.lab2.model.OwnerDTO;
import com.example.lab2.model.OwnerDTOMapper;
import com.example.lab2.repository.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepo repository;
    @Autowired
    private OwnerDTOMapper ownerDTOMapper;

    public void saveOwner(Owner owner){ repository.save(owner);}

    public void deleteOwnerById(int id){ repository.deleteById(id);}

    public List<OwnerDTO> getAllOwners(){
        return repository.findAll()
                .stream()
                .map(ownerDTOMapper)
                .collect(Collectors.toList());
    }

    public Owner getOwnerById(int id){ return repository.findById(id).orElse(null);}

    public Owner updateOwner(Owner newOwner){
        Owner existingOwner = repository.findById(newOwner.getId()).orElse(null);
        existingOwner.setName(newOwner.getName());
        existingOwner.setJob(newOwner.getJob());
        existingOwner.setHeight(newOwner.getHeight());
        existingOwner.setHowOld(newOwner.getHowOld());
        existingOwner.setOwnedCarNb(newOwner.getOwnedCarNb());
        existingOwner.setCars(newOwner.getCars());
        existingOwner.setHouses(newOwner.getHouses());
        return repository.save(existingOwner);
    }
}
