package com.bankingapi.bankingproject.controller;
import java.util.List;
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
import com.bankingapi.bankingproject.Service.TransactionMasterService;
import com.bankingapi.bankingproject.model.TransactionMaster;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/transaction")
public class TransactionMasterController {
    
    @Autowired
    TransactionMasterService _TransactionMasterService;

    Logger logger = LoggerFactory.getLogger(BankingApplication.class);

    @PostMapping("/transaction")
    public ResponseEntity<TransactionMaster> Save(@RequestBody TransactionMaster cm) {
        try {
			TransactionMaster ObjTrn = _TransactionMasterService.Save(cm);
			logger.info("Info | Post Save Transaction Success " + cm.getTxnid());
			return new ResponseEntity<>(ObjTrn, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error | Post Error Saving Transacton " + cm.getTxnid());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
        // List<TransactionMaster> ObjAccount = new ArrayList<TransactionMaster>();
        // _TransactionMasterRepo.findAll().forEach(ObjAccount::add);
        // TransactionMaster Obj = new TransactionMaster();
        // Obj.setBranchid(cm.getBranchid());
        // Obj.setTxndate(cm.getTxndate());
        // Obj.setTxnid(cm.getTxnid());
        // Obj.setAccountid(cm.getAccountid());
        // Obj.setInstrno(cm.getInstrno());
        // Obj.setNarration(cm.getNarration());
        // Obj.setMaker(cm.getMaker());
        // Obj.setDrcr(cm.getDrcr());
        // Obj.setOpeningbalance(cm.getOpeningbalance());
        // Obj.setTxnamount(cm.getTxnamount());
        // Obj.setClossingbalance(cm.getClossingbalance());
        // _TransactionMasterRepo.save(Obj);
        // return new ResponseEntity<>(Obj, HttpStatus.OK);
    }



    @GetMapping("/statement/{account}")
    public ResponseEntity<List<TransactionMaster>> statement(@PathVariable("account") Integer account) {
        try {
			List<TransactionMaster> ObjTrn = _TransactionMasterService.Statement(account);
			logger.info("Info | Post View Transaction Success " + account);
			return new ResponseEntity<>(ObjTrn, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error | Post Error Saving Transacton " + account);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
