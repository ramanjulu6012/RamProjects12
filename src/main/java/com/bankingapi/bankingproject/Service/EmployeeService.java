package com.bankingapi.bankingproject.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankingapi.bankingproject.model.EmployeeMaster;
import com.bankingapi.bankingproject.repository.EmployeeMasterRepo;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeMasterRepo _EmployeeMasterRepo;

    public List<EmployeeMaster> GetAllEmployee() {
        List<EmployeeMaster> Obj = new ArrayList<EmployeeMaster>();
        _EmployeeMasterRepo.findAll().forEach(Obj::add);
        return Obj;
    }

    public EmployeeMaster save(EmployeeMaster emp) {
        return _EmployeeMasterRepo.save(emp);
    }

    public EmployeeMaster findEmployeebyId(Integer Usd, String Pwd) {
        Optional<EmployeeMaster> ObjData = _EmployeeMasterRepo.findById(Usd);
        if (ObjData.get().getPassword().equals(Pwd)) {
            return ObjData.get();
        }
        return null;
    }

}
