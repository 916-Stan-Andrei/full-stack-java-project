package com.example.lab2.api;

import com.example.lab2.model.InsuranceCompany;
import com.example.lab2.model.InsuranceCompanyDTO;
import com.example.lab2.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/addCompany")
    public void addCompany(@RequestBody InsuranceCompany company){companyService.saveCompany(company);}

    @GetMapping("/companies")
    public List<InsuranceCompanyDTO> getAllCompanies(){return companyService.getCompanies();}

    @GetMapping("/company/{id}")
    public InsuranceCompanyDTO getCompany(@PathVariable int id){return companyService.getCompanyById(id);}

    @DeleteMapping("/deleteCompany/{id}")
    public void deleteCompany(@PathVariable int id){companyService.deleteCompany(id);}

    @PutMapping("/updateCompany")
    public InsuranceCompany updateCompany(@RequestBody InsuranceCompany company){return companyService.updateCompany(company);}

}
