package com.example.lab2.model;

public record ContractDTO(
        int id,
        int company_id,
        int car_id,
        int papersNb,
        boolean isOfficial,
        String deadline,
        String signingDate
) {
}
