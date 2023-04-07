package com.example.lab2.service;

import com.example.lab2.model.InsuranceCompany;
import com.example.lab2.model.InsuranceCompanyDTO;
import com.example.lab2.model.InsuranceCompanyDTOMapper;
import com.example.lab2.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepo repository;

    @Autowired
    private InsuranceCompanyDTOMapper insuranceCompanyDTOMapper;

    public void saveCompany(InsuranceCompany company){repository.save(company);}

    public InsuranceCompanyDTO getCompanyById(int id){return repository.findById(id).map(insuranceCompanyDTOMapper).orElse(null);}

    public List<InsuranceCompanyDTO> getCompanies(){
        return repository.findAll()
                .stream()
                .map(insuranceCompanyDTOMapper)
                .collect(Collectors.toList());
    }

    public void deleteCompany(int id){repository.deleteById(id);}

    public InsuranceCompany updateCompany(InsuranceCompany company){
        InsuranceCompany existingCompany =  repository.findById(company.getId()).orElse(null);
        existingCompany.setCompanyName(company.getCompanyName());
        existingCompany.setAddress(company.getAddress());
        existingCompany.setBudget(company.getBudget());
        existingCompany.setInternational(company.isInternational());
        existingCompany.setOfficesNb(company.getOfficesNb());
        existingCompany.setContracts(company.getContracts());
        return repository.save(existingCompany);
    }

}
