package com.bankingapi.bankingproject.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankingapi.bankingproject.model.CustomerLogin;
import com.bankingapi.bankingproject.model.CustomerMaster;
import com.bankingapi.bankingproject.model.CustomerBeneficiaries;
import com.bankingapi.bankingproject.repository.CustomerLoginRepo;
import com.bankingapi.bankingproject.repository.CustomerMasterRepo;
import com.bankingapi.bankingproject.repository.CustomerBeneficiariesRepo;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerLoginRepo _CustomerLoginRepo;

    @Autowired
    CustomerBeneficiariesRepo _Customer_BeneficiariesRepo;

    @Autowired
    CustomerMasterRepo _CustomerMasterRepo;
    

    public CustomerLogin save(CustomerLogin ObjCustLogin) {
        return _CustomerLoginRepo.save(ObjCustLogin);
    }

    public CustomerMaster saveCustomer(CustomerMaster ObjCustMaster) {
        return _CustomerMasterRepo.save(ObjCustMaster);
    }

    public Optional<CustomerMaster> GetCustomer(Integer account) {
        return _CustomerMasterRepo.findById(account);
    }

    public CustomerMaster findEmployeebyId(Integer Usd, String Pwd) {
        Optional<CustomerMaster> ObjData = _CustomerMasterRepo.findById(Usd);
        if (ObjData.get().getPassword().equals(Pwd)) {
            return ObjData.get();
        }
        return null;
    }

    public List<CustomerBeneficiaries> GetBenbyCustomerId(Integer account) {
        return _Customer_BeneficiariesRepo.findByaccountid(account);
    }

    public CustomerMaster ValidateCustbyCustomerIdAndPan(Integer Usd,String PAN){
        Optional<CustomerMaster> ObjData = _CustomerMasterRepo.findById(Usd);
        if (ObjData.get().getPanno().equals(PAN)) {
        return ObjData.get();   
        }
        return null;

    }
}
