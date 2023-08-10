package com.bankingapi.bankingproject.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingapi.bankingproject.repository.Customer_BeneficiariesRepo;

@Service
@Transactional
public class Customer_BeneficiariesService {
    
    @Autowired
    Customer_BeneficiariesRepo _Customer_BeneficiariesRepo;


    
}
