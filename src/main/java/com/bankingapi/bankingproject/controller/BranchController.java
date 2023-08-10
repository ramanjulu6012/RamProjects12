package com.bankingapi.bankingproject.controller;
import java.util.List;
import java.util.Optional;
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
import com.bankingapi.bankingproject.Service.BranchMasterService;
import com.bankingapi.bankingproject.model.BranchMaster;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/branch")
public class BranchController {
	@Autowired
	BranchMasterService _BranchMasterService;

	@GetMapping("/branch")
	public ResponseEntity<List<BranchMaster>> getbranch(@RequestParam(required = false) Integer id) {
		List<BranchMaster> ObjBranch = _BranchMasterService.GetAllBranch();
		if (!ObjBranch.isEmpty()) {
			return new ResponseEntity<>(ObjBranch, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/findbyid")
	public ResponseEntity<Optional<BranchMaster>> findbranchbyname(@RequestParam(required = false) Integer id) {
		Optional<BranchMaster> ObjBranch = _BranchMasterService.GetAccount(id);
		if (ObjBranch.isPresent()) {
			return new ResponseEntity<>(ObjBranch, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/branch")
	public ResponseEntity<BranchMaster> AddUpdateBranch(@RequestBody BranchMaster cm) {
		try {
			BranchMaster ObjBranch = _BranchMasterService.save(cm);
			return new ResponseEntity<>(ObjBranch, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
