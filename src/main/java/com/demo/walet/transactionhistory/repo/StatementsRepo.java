package com.demo.walet.transactionhistory.repo;

import com.demo.walet.transactionhistory.models.entity.AccountStatements;
import com.demo.walet.transactionhistory.models.entity.Transactions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface StatementsRepo extends JpaRepository<AccountStatements, Integer> {

    Page<AccountStatements> findByWalletId(Integer walletId, Pageable pageable);
    Page<AccountStatements> findByWalletIdAndStmtDateBefore(Integer walletId, Date date, Pageable pageable);




}
