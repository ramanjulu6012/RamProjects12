package com.bankingapi.bankingproject.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankingapi.bankingproject.model.CustomerBeneficiaries;
import com.bankingapi.bankingproject.repository.CustomerBeneficiariesRepo;

@Service
@Transactional
public class CustomerBeneficiariesService {
    
    @Autowired
    CustomerBeneficiariesRepo _Customer_BeneficiariesRepo;

     public CustomerBeneficiaries save(CustomerBeneficiaries ObjCustLogin)
    {       
        return _Customer_BeneficiariesRepo.save(ObjCustLogin);
    }



    
}
