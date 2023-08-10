package com.bankingapi.bankingproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingapi.bankingproject.model.Customer_Beneficiaries;

public interface Customer_BeneficiariesRepo extends JpaRepository<Customer_Beneficiaries, Integer> {
    
}
