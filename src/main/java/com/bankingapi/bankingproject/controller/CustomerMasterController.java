package com.bankingapi.bankingproject.controller;
import java.util.Optional;
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
import com.bankingapi.bankingproject.Service.CustomerService;
import com.bankingapi.bankingproject.model.CustomerMaster;
import com.bankingapi.bankingproject.model.EmployeeLogin;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer")
public class CustomerMasterController {
	@Autowired
	CustomerService _CustomerService;
	// CustomerMasterRepo _CustomerMasterRepo;

	@GetMapping("/customer/{id}")
	public ResponseEntity<Optional<CustomerMaster>> getcustomer(@PathVariable("id") Integer id) {
		// Optional<CustomerMaster> ObjData = _CustomerMasterRepo.findById(id);
		// if (ObjData.isPresent()) {
		// 	return new ResponseEntity<>(ObjData.get(), HttpStatus.OK);
		// } else {
		// 	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		// }

		Optional<CustomerMaster> ObjAcctount = _CustomerService.GetCustomer(id);
		if (ObjAcctount.isPresent()) {
			return new ResponseEntity<>(ObjAcctount, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}



	}

	// @GetMapping("/customer")
	// public ResponseEntity<List<CustomerMaster>> getcustomers(@RequestParam(required = false) Integer id) {
	// 	try {
	// 		List<CustomerMaster> Obj = new ArrayList<CustomerMaster>();
	// 		if (id == null) {
	// 			_CustomerMasterRepo.findAll().forEach(Obj::add);
	// 		} else {
	// 			_CustomerMasterRepo.findBycustomerid(id).forEach(Obj::add);
	// 		}
	// 		if (Obj.isEmpty()) {
	// 			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// 		}
	// 		return new ResponseEntity<>(Obj, HttpStatus.OK);
	// 	} catch (Exception e) {
	// 		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	// 	}
	// }


	 @PostMapping("/login")
    public ResponseEntity<CustomerMaster> EmployeeLogin(@RequestBody EmployeeLogin emp){ 
        CustomerMaster Obj =  _CustomerService.findEmployeebyId(emp.getUserid(),emp.getPassword());
        if (Obj == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        };
        return  new ResponseEntity<>(Obj, HttpStatus.OK);
    }


	@PostMapping("/customer")
	public ResponseEntity<CustomerMaster> AddUpdateCustomer(@RequestBody CustomerMaster cm) {
		try {
			CustomerMaster ObjCust= _CustomerService.saveCustomer(cm);
			return new ResponseEntity<>(ObjCust, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// CustomerMaster Cust = new CustomerMaster();
		// Cust.setCustomerid(cm.getCustomerid());
		// Cust.setAadharno(cm.getAadharno());
		// Cust.setAddress1(cm.getAddress1());
		// Cust.setAddress2(cm.getAddress2());
		// Cust.setAddress3(cm.getAddress3());
		// Cust.setCity(cm.getCity());
		// Cust.setDob(cm.getDob());
		// Cust.setEmailid(cm.getEmailid());
		// Cust.setGender(cm.getGender());
		// Cust.setLongname(cm.getLongname());
		// Cust.setMobile(cm.getMobile());
		// Cust.setPanno(cm.getPanno());
		// _CustomerMasterRepo.save(Cust);

		// return new ResponseEntity<>(Cust, HttpStatus.OK);
	}

}
