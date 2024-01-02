package com.bankingapi.bankingproject.Service;
import java.util.Optional;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankingapi.bankingproject.BankingProjectApplication;
import com.bankingapi.bankingproject.model.CustomerLogin;
import com.bankingapi.bankingproject.repository.CustomerLoginRepo;


@Service
@Transactional
public class CustomerLoginService {

    @Autowired
    CustomerLoginRepo _CustomerLoginRepo;
    Logger logger = LoggerFactory.getLogger(BankingProjectApplication.class);

    public CustomerLogin CustomerLogin(CustomerLogin ObjCusLogin) {
        Optional<CustomerLogin> ObjData = _CustomerLoginRepo.findById(ObjCusLogin.getCustomerid());
        if (ObjData.isPresent()) {
            CustomerLogin Emp = ObjData.get();
            if (Emp.getPassword() == ObjCusLogin.getPassword()) {
                logger.info("Info | Get CustomerLogin Success " + ObjCusLogin.getCustomerid());
                return ObjCusLogin;
            }
        }
        return null;
    }
    
}
