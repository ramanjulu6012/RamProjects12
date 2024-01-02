package com.bankingapi.bankingproject.repository;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import com.bankingapi.bankingproject.model.AccountMaster;

public interface AccountMasterRepo extends JpaRepository<AccountMaster, Integer> {

    // @Query(value="update account_master set balance=:balance where
    // accountno=:accountno)", nativeQuery = true)
    // Float UpdateAccountMasterBalance(@Param("accountno") Integer accountno,
    // @Param("balance") Float balance);

}
