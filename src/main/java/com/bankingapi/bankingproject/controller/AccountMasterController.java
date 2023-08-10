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
import com.bankingapi.bankingproject.Service.AccountMasterService;
import com.bankingapi.bankingproject.model.AccountMaster;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/account")
public class AccountMasterController {

	@Autowired
	AccountMasterService _AccountMasterService;

	@GetMapping("/account/{account}")
	public ResponseEntity<Optional<AccountMaster>> Get(@PathVariable("account") Integer account) {
		Optional<AccountMaster> ObjAcctount = _AccountMasterService.GetAccount(account);
		if (ObjAcctount.isPresent()) {
			return new ResponseEntity<>(ObjAcctount, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<AccountMaster> Update(@RequestBody AccountMaster am) {
		try {
			AccountMaster ObjAccount = _AccountMasterService.save(am);
			return new ResponseEntity<>(ObjAccount, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
