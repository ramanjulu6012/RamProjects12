package com.bankingapi.bankingproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingapi.bankingproject.model.CustomerBeneficiaries;

public interface CustomerBeneficiariesRepo extends JpaRepository<CustomerBeneficiaries, Integer> {
    
    List<CustomerBeneficiaries> findByaccountid(Integer customerid);
}
