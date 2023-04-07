package com.example.lab2.api;

import com.example.lab2.model.OwnerDTO;
import com.example.lab2.service.OwnerCarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OwnerCarController {
    @Autowired
    private OwnerCarDTO ownerCarDTO;

    @GetMapping("/ownersbyspeed")
    private List<OwnerDTO> getOwnersByMaxSpeed(){return ownerCarDTO.getOwnersOrderedByFastestCar();}
}
