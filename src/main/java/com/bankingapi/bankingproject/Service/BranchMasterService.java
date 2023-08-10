package com.bankingapi.bankingproject.Service;
import java.util.ArrayList;
import java.util.Optional;
import javax.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankingapi.bankingproject.model.BranchMaster;
import com.bankingapi.bankingproject.repository.BranchMasterRepo;

@Service
@Transactional
public class BranchMasterService {
    //sss
    @Autowired
    BranchMasterRepo _BranchMasterRepo;

    public BranchMaster save(BranchMaster ObjBranch) {
        BranchMaster Obj = new BranchMaster();
        Obj.setId(ObjBranch.getId());
        Obj.setName(ObjBranch.getName());
        return _BranchMasterRepo.save(ObjBranch);

    }

    public Optional<BranchMaster> GetAccount(Integer branch){
        return _BranchMasterRepo.findById(branch);
    }

     public List<BranchMaster> GetAllBranch(){
        List<BranchMaster> Obj = new ArrayList<BranchMaster>();
        _BranchMasterRepo.findAll().forEach(Obj::add);
        return Obj;
    }

}
