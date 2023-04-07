package com.example.lab2.service;

import com.example.lab2.model.Contract;
import com.example.lab2.model.ContractDTO;
import com.example.lab2.model.ContractDTOMapper;
import com.example.lab2.repository.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractService {

    @Autowired
    private ContractRepo repository;

    @Autowired
    private ContractDTOMapper contractDTOMapper;

    public void saveContract(Contract contract){repository.save(contract);}

    public List<ContractDTO> getAllContracts(){
        return  repository.findAll()
                .stream()
                .map(contractDTOMapper)
                .collect(Collectors.toList());
    }

    public ContractDTO getContractById(int id){return repository.findById(id).map(contractDTOMapper).orElse(null);}

    public void deleteContract(int id){repository.deleteById(id);}

    public Contract updateContract(Contract contract){
        Contract existingContract = repository.findById(contract.getId()).orElse(null);
        existingContract.setOfficial(contract.isOfficial());
        existingContract.setDeadline(contract.getDeadline());
        existingContract.setPapersNb(contract.getPapersNb());
        existingContract.setSigningDate(contract.getSigningDate());
        existingContract.setCar(contract.getCar());
        existingContract.setInsuranceCompany(contract.getInsuranceCompany());
        return repository.save(existingContract);
    }
}
