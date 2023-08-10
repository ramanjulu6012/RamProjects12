package com.bankingapi.bankingproject.Service;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankingapi.bankingproject.model.AccountMaster;
import com.bankingapi.bankingproject.repository.AccountMasterRepo;

@Service
@Transactional
public class AccountMasterService {
    @Autowired
    AccountMasterRepo _AccountMasterRepo;

    public AccountMaster save(AccountMaster objAccount) {
        AccountMaster Obj = new AccountMaster();
        Obj.setBranchid(objAccount.getBranchid());
        Obj.setAccountno(objAccount.getAccountno());
        Obj.setProductid(objAccount.getProductid());
        Obj.setCustomerid(objAccount.getCustomerid());
        Obj.setAccountstatus(objAccount.getAccountstatus());
        Obj.setAccountopendate(objAccount.getAccountopendate());
        Obj.setBalance(objAccount.getBalance());
        Obj.setAccountclosedate(objAccount.getAccountclosedate());
        Obj.setModeofoperation(objAccount.getModeofoperation());
        Obj.setOpenbyuser(objAccount.getOpenbyuser());
        Obj.setAccountopendate(objAccount.getAccountopendate());
        Obj.setClosedbyuser(objAccount.getClosedbyuser());
        return _AccountMasterRepo.save(objAccount);
    }

    public Optional<AccountMaster> GetAccount(Integer account){
        return _AccountMasterRepo.findById(account);
    }
    
}
