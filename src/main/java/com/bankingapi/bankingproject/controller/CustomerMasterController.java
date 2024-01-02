package com.bankingapi.bankingproject.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingapi.bankingproject.BankingProjectApplication;
import com.bankingapi.bankingproject.Service.CustomerService;
import com.bankingapi.bankingproject.Service.CustomerBeneficiariesService;
import com.bankingapi.bankingproject.model.CustomerMaster;
import com.bankingapi.bankingproject.model.CustomerBeneficiaries;
import com.bankingapi.bankingproject.model.EmployeeLogin;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer")
public class CustomerMasterController {
	@Autowired
	CustomerService _CustomerService;

	@Autowired
	CustomerBeneficiariesService _BeneficiariesService;

	Logger logger = LoggerFactory.getLogger(BankingProjectApplication.class);

	@GetMapping("/customer/{id}")
	public ResponseEntity<Optional<CustomerMaster>> getcustomer(@PathVariable("id") Integer id) {
		Optional<CustomerMaster> ObjAcctount = _CustomerService.GetCustomer(id);
		if (ObjAcctount.isPresent()) {
			logger.info("INFO | Get customer Success " + id);
			return new ResponseEntity<>(ObjAcctount, HttpStatus.OK);
		} else {
			logger.error("Error | Customer not found " + id);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<CustomerMaster> EmployeeLogin(@RequestBody EmployeeLogin emp) {
		CustomerMaster Obj = _CustomerService.findEmployeebyId(emp.getUserid(), emp.getPassword());
		if (Obj == null) {
			logger.error("Error | Post Login Fail " + emp.getUserid());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		logger.info("INFO | Post Login Success " + emp.getUserid());
		return new ResponseEntity<>(Obj, HttpStatus.OK);
	}

	@PostMapping("/customer")
	public ResponseEntity<CustomerMaster> AddUpdateCustomer(@RequestBody CustomerMaster cm) {
		try {
			CustomerMaster ObjCust = _CustomerService.saveCustomer(cm);
			logger.info("Info | Post CustomerMaster add/update Success " + cm.getCustomerid());
			return new ResponseEntity<>(ObjCust, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error | Post CustomerMaster add/update Fail " + cm.getCustomerid());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/validatecustbyidandpan")
	public ResponseEntity<CustomerMaster> ValidateCustomerbyIdandPAN(@RequestBody CustomerMaster cm) {
		try {
			CustomerMaster ObjCust = _CustomerService.ValidateCustbyCustomerIdAndPan(cm.getCustomerid(), cm.getPanno());
			logger.info("Info | Post validatecustbyidandpan Success " + cm.getCustomerid());
			return new ResponseEntity<>(ObjCust, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error | Post validatecustbyidandpan Fail " + cm.getCustomerid());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addbenef")
	public ResponseEntity<CustomerBeneficiaries> AddCustomerBenf(@RequestBody CustomerBeneficiaries cm) {
		try {
			CustomerBeneficiaries ObjCust = _BeneficiariesService.save(cm);
			logger.info("Info | Post addbenef Success " + cm.getCustomerid());
			return new ResponseEntity<>(ObjCust, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error | Post addbenef Fail " + cm.getCustomerid());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/customerbenf/{id}")
	public ResponseEntity<List<CustomerBeneficiaries>> getcustomerBenf(@PathVariable("id") Integer id) {
		List<CustomerBeneficiaries> ObjAcctount = _CustomerService.GetBenbyCustomerId(id);
		if (ObjAcctount != null) {
			logger.info("Info | Get customerbenf Success " + id);
			return new ResponseEntity<>(ObjAcctount, HttpStatus.OK);
		} else {
			logger.error("Error | Post customerbenf Fail " + id);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
