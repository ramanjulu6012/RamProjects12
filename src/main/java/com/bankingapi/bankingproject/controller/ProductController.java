package com.bankingapi.bankingproject.controller;
import java.util.List;
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

import com.bankingapi.bankingproject.Service.ProductService;
//import com.bankingapi.bankingproject.Service.ProductMasterService;
import com.bankingapi.bankingproject.model.ProductMaster;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService _ProductService;
	
	@GetMapping("/product/{productid}")
	public ResponseEntity<Optional<ProductMaster>> getciruclarsbyId(@PathVariable("productid") Integer productid) {
		Optional<ProductMaster> ObjAcctount = _ProductService.GetProduct(productid);
		if (ObjAcctount.isPresent()) {
			return new ResponseEntity<>(ObjAcctount, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@GetMapping("/product/")
	public ResponseEntity<List<ProductMaster>> getbranch() {
		List<ProductMaster> Obj = _ProductService.GetAllProduct();
		if (!Obj.isEmpty()) {
			return new ResponseEntity<>(Obj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@PostMapping("/product")
	public ResponseEntity<ProductMaster> UpdateProduct(@RequestBody ProductMaster Obj) {
		try {
			ProductMaster ObjAccount = _ProductService.save(Obj);
			return new ResponseEntity<>(ObjAccount, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
