package com.example.lab2.model;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ContractDTOMapper implements Function<Contract, ContractDTO> {
    @Override
    public ContractDTO apply(Contract contract){
        return new ContractDTO(
                contract.getId(),
                contract.getCar().getId(),
                contract.getInsuranceCompany().getId(),
                contract.getPapersNb(),
                contract.isOfficial(),
                contract.getDeadline(),
                contract.getSigningDate()
        );
    }
}
