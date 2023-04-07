package com.example.lab2.api;

import com.example.lab2.model.House;
import com.example.lab2.model.HouseDTO;
import com.example.lab2.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HouseController {

    @Autowired
    private HouseService houseService;

    @PostMapping("/addHouse")
    public void addHouse(@RequestBody House house){ houseService.saveHouse(house);}

    @GetMapping("/houses")
    public List<HouseDTO> getAllHouses(){return houseService.getAllHouses();}

    @GetMapping("/getHouse/{id}")
    public HouseDTO getHouseById(@PathVariable int id){return houseService.getHouse(id);}

    @DeleteMapping("/deleteHouse/{id}")
    public void deleteHouse(@PathVariable int id){houseService.deleteHouse(id);}

    @PutMapping("/updateHouse")
    public House updateHouse(@RequestBody House house){return houseService.updateHouse(house);}
}
