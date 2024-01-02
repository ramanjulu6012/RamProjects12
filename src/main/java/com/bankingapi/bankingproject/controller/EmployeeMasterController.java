package com.bankingapi.bankingproject.controller;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankingapi.bankingproject.BankingProjectApplication;
import com.bankingapi.bankingproject.Service.EmployeeService;
import com.bankingapi.bankingproject.model.EmployeeLogin;
import com.bankingapi.bankingproject.model.EmployeeMaster;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeMasterController {

    @Autowired
    EmployeeService _EmployeeService;

    Logger logger = LoggerFactory.getLogger(BankingProjectApplication.class);

    @GetMapping("/employee")
	public ResponseEntity<List<EmployeeMaster>> getbranch(@RequestParam(required = false) Integer id) {
		List<EmployeeMaster> ObjBranch = _EmployeeService.GetAllEmployee();
		if (!ObjBranch.isEmpty()) {
			return new ResponseEntity<>(ObjBranch, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    @PostMapping("/save")
    public ResponseEntity<EmployeeMaster> SaveEmployee(@RequestBody EmployeeMaster emp){
        return  new ResponseEntity<>(_EmployeeService.save(emp), HttpStatus.OK); 
    }
    @PostMapping("/login")
    public ResponseEntity<EmployeeMaster> EmployeeLogin(@RequestBody EmployeeLogin emp){ 
        EmployeeMaster Emp =  _EmployeeService.findEmployeebyId(emp.getUserid(),emp.getPassword());
        if (Emp == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        };
        return  new ResponseEntity<>(Emp, HttpStatus.OK);
    }
}
