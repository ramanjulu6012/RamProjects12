package com.bankingapi.bankingproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bankingapi.bankingproject.model.ProductMaster;

public interface ProductMasterRepo extends JpaRepository<ProductMaster,Integer> {
    //List<ProductMaster> findByid(ProductMasterPk id);
    //List<ProductMaster> findBybranchId(ProductMasterPk id);
}
