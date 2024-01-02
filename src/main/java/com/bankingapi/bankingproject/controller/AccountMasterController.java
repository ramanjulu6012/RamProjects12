package com.bankingapi.bankingproject.controller;
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

import com.bankingapi.bankingproject.BankingApplication;
import com.bankingapi.bankingproject.Service.AccountMasterService;
import com.bankingapi.bankingproject.model.AccountMaster;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/account")
public class AccountMasterController {

	@Autowired
	AccountMasterService _AccountMasterService;

	Logger logger = LoggerFactory.getLogger(BankingApplication.class);


	@GetMapping("/account/{account}")
	public ResponseEntity<Optional<AccountMaster>> Get(@PathVariable("account") Integer account) {
		Optional<AccountMaster> ObjAcctount = _AccountMasterService.GetAccount(account);
		if (ObjAcctount.isPresent()) {
			logger.info("Info | Get Account Success " + account);
			return new ResponseEntity<>(ObjAcctount, HttpStatus.OK);
		} else {
			logger.error("Error | Get Account Error " + account);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<AccountMaster> Update(@RequestBody AccountMaster am) {
		try {
			AccountMaster ObjAccount = _AccountMasterService.save(am);
			logger.info("Info | Post Update Account Success " + am.getAccountno());
			return new ResponseEntity<>(ObjAccount, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error | Post Update Account Error " + am.getAccountno());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
