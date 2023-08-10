package com.bankingapi.bankingproject.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingapi.bankingproject.model.ProductMaster;
import com.bankingapi.bankingproject.repository.ProductMasterRepo;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    ProductMasterRepo _ProductMasterRepo;

    public ProductMaster save(ProductMaster objAccount) {
        return _ProductMasterRepo.save(objAccount);
    }

    public Optional<ProductMaster> GetProduct(Integer ProductCode){
        return _ProductMasterRepo.findById(ProductCode);
    }

     public List<ProductMaster> GetAllProduct(){
        List<ProductMaster> Obj = new ArrayList<ProductMaster>();
        _ProductMasterRepo.findAll().forEach(Obj::add);
        return Obj;
    }

}
