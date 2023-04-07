package com.example.lab2.model;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class InsuranceCompanyDTOMapper implements Function<InsuranceCompany, InsuranceCompanyDTO> {
    @Override
    public InsuranceCompanyDTO apply(InsuranceCompany insuranceCompany){
        return new InsuranceCompanyDTO(
                insuranceCompany.getId(),
                insuranceCompany.getCompanyName(),
                insuranceCompany.getBudget(),
                insuranceCompany.getAddress(),
                insuranceCompany.getOfficesNb(),
                insuranceCompany.isInternational()
        );
    }
}
