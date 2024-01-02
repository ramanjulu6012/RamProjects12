package com.bankingapi.bankingproject.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingapi.bankingproject.model.AccountMaster;
import com.bankingapi.bankingproject.model.TransactionMaster;
import com.bankingapi.bankingproject.repository.AccountMasterRepo;
import com.bankingapi.bankingproject.repository.TransactionMasterRepo;

@Service
@Transactional
public class TransactionMasterService {

    @Autowired
    TransactionMasterRepo _TransactionMasterRepo;

    @Autowired
    AccountMasterRepo _AccountMasterRepo;

    @Autowired
    AccountMasterService _AccountMasterService;

    public TransactionMaster Save(TransactionMaster Obj){
        
        Float TxnAmount = Obj.getTxnamount();
        TransactionMaster PriviousRecord = _TransactionMasterRepo.GetBalance(Obj.getAccountid());
        Float OldBalance = PriviousRecord.getClossingbalance();
        Float Balance = OldBalance-TxnAmount;
        if(Balance<0 && Obj.getDrcr().equals("Dr"))
        {
            return null;
        }
        if(Obj.getDrcr().equals("Cr")){            
            Balance=OldBalance+TxnAmount;
        }

        TransactionMaster NewTxn = new TransactionMaster();
        NewTxn.setAccountid(Obj.getAccountid());
        NewTxn.setBranchid(Obj.getBranchid());
        
        NewTxn.setOpeningbalance(PriviousRecord.getClossingbalance());
        NewTxn.setClossingbalance(Balance);
       // _AccountMasterRepo.UpdateAccountMasterBalance(Obj.getAccountid(), Balance);

       Optional<AccountMaster> ObjAcctount = _AccountMasterService.GetAccount(Obj.getAccountid());
       AccountMaster tmp = ObjAcctount.get();
       tmp.setBalance(Balance);
       _AccountMasterRepo.save(tmp);

        NewTxn.setTxnamount(Obj.getTxnamount());
        NewTxn.setDrcr(Obj.getDrcr());
        NewTxn.setInstrno(Obj.getInstrno());
        NewTxn.setMaker(Obj.getMaker());
        NewTxn.setNarration(Obj.getNarration());
        NewTxn.setTxndate(Obj.getTxndate());
        NewTxn.setTxnid(Obj.getTxnid());

        return _TransactionMasterRepo.save(NewTxn);
    }

    public List<TransactionMaster> Statement(Integer Account){
        try {
            return _TransactionMasterRepo.findByaccountid(Account);
        } catch (Exception e) {
            return null;
        }
    }
    
}
