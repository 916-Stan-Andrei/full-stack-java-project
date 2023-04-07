package com.example.lab2.api;

import com.example.lab2.model.Contract;
import com.example.lab2.model.ContractDTO;
import com.example.lab2.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContractController {
    @Autowired
    private ContractService contractService;

    @PostMapping("/addContract")
    public void addContract(@RequestBody Contract contract){contractService.saveContract(contract);}

    @GetMapping("/contracts")
    public List<ContractDTO> getAllContracts(){return contractService.getAllContracts();}

    @GetMapping("/contract/{id}")
    public ContractDTO getContract(@PathVariable int id){return contractService.getContractById(id);}

    @DeleteMapping("/deleteContract/{id}")
    public void deleteContract(@PathVariable int id){contractService.deleteContract(id);}

    @PutMapping("/updateContract")
    public Contract updateContract(@RequestBody Contract contract){return contractService.updateContract(contract);}
}
