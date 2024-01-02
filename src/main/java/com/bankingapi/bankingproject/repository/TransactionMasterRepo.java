package com.bankingapi.bankingproject.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bankingapi.bankingproject.model.TransactionMaster;

public interface TransactionMasterRepo extends JpaRepository<TransactionMaster, Integer> {

    List<TransactionMaster> findByaccountid(Integer accountid);

    @Query(value="Select * from Transaction_master where txnid=(select Max(txnid) from Transaction_master where accountid=:accountid)", nativeQuery = true)
    TransactionMaster GetBalance(@Param("accountid") Integer accountid);

    
    
}
