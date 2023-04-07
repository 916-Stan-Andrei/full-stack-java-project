package com.example.lab2.api;

import com.example.lab2.model.OwnerDTO;
import com.example.lab2.service.OwnerHouseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OwnerHouseController {
    @Autowired
    private OwnerHouseDTO ownerHouseDTO;

    @GetMapping("/ownersbysurface")
    private List<OwnerDTO> getOwnersByHouseSurface(){return ownerHouseDTO.getOwnersOrderedByAverageSurfaceOfHouses();}
}
