package com.bankingapi.bankingproject.controller;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bankingapi.bankingproject.BankingApplication;
import com.bankingapi.bankingproject.Service.CustomerLoginService;
import com.bankingapi.bankingproject.model.CustomerLogin;
import com.bankingapi.bankingproject.model.CustomerMaster;
import com.bankingapi.bankingproject.repository.CustomerLoginRepo;
import com.bankingapi.bankingproject.repository.CustomerMasterRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customerlogin")
public class CustomerLoginController {
    @Autowired
    CustomerLoginRepo _CustomerLoginRepo;
    @Autowired
    CustomerMasterRepo _CustomerMasterRepo;

    @Autowired
    CustomerLoginService _CustomerLoginService;

    Logger logger = LoggerFactory.getLogger(BankingApplication.class);

    @GetMapping("/login")
    public ResponseEntity<CustomerLogin> CustomerLogin(@RequestBody CustomerLogin UserObj) {

        CustomerLogin ObjLogin =  _CustomerLoginService.CustomerLogin(UserObj);
        if(ObjLogin!=null){
            return new ResponseEntity<>(UserObj, HttpStatus.OK);
        }
        // Optional<CustomerLogin> ObjData = _CustomerLoginRepo.findById(UserObj.getCustomerid());
        // if (ObjData.isPresent()) {
        //     CustomerLogin Emp = ObjData.get();
        //     if (Emp.getPassword() == UserObj.getPassword()) {
        //         logger.info("Info | Get CustomerLogin Success " + UserObj.getCustomerid());
        //         return new ResponseEntity<>(UserObj, HttpStatus.OK);
        //     }
        // }

        logger.error("Error | Get CustomerLogin Error " + UserObj.getCustomerid());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/signup")
    public ResponseEntity<CustomerLogin> SignUp(@RequestBody CustomerLogin cm) {
        Optional<CustomerMaster> ObjData = _CustomerMasterRepo.findById(cm.getCustomerid());
        if (ObjData.isPresent()) {
            CustomerLogin Cust = new CustomerLogin();
            Cust.setCustomerid(cm.getCustomerid());
            Cust.setPassword(cm.getPassword());
            _CustomerLoginRepo.save(Cust);
            logger.info("Info | Post Signup Success " + cm.getCustomerid());
            return new ResponseEntity<>(Cust, HttpStatus.OK);
        }

        logger.error("Error | Post Signup Error " + cm.getCustomerid());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
