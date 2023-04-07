package com.example.lab2.api;

import com.example.lab2.model.Owner;
import com.example.lab2.model.OwnerDTO;
import com.example.lab2.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/addOwner")
    public void addOwner(@RequestBody Owner owner){ ownerService.saveOwner(owner);}

    @GetMapping("/owners")
    public List<OwnerDTO> getAllOwners(){return ownerService.getAllOwners();}

    @GetMapping("/getOwner/{id}")
    public Owner getOwner(@PathVariable int id){ return ownerService.getOwnerById(id);}

    @DeleteMapping("/deleteOwner/{id}")
    public void deleteOwner(@PathVariable int id){ownerService.deleteOwnerById(id);}

    @PutMapping("/updateOwner")
    public Owner updateOwner(@RequestBody Owner owner){ return ownerService.updateOwner(owner);}
}
