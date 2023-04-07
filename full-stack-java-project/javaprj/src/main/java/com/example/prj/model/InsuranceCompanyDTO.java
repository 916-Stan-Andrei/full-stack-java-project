package com.example.lab2.model;

public record InsuranceCompanyDTO(
        int id,
        String companyName,
        int budget,
        String address,
        int officesNb,
        boolean international
) {
}
