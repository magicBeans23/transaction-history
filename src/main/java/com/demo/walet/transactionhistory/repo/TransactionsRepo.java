package com.demo.walet.transactionhistory.repo;

import com.demo.walet.transactionhistory.models.entity.Transactions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TransactionsRepo extends JpaRepository<Transactions, Integer> {

    Page<Transactions> findByWalletId(Integer walletId, Pageable pageable);
    Page<Transactions> findByTransactionId(Integer transactionId, Pageable pageable);
    Page<Transactions> findByWalletIdAndTransactionId(Integer wallerId, Integer transactionId, Pageable pageable);
    //Page<Transactions> findByWalletIdAndTransactionType(Integer walletId, Integer transactiontype, Pageable pageable);
    Page<Transactions> findByWalletIdAndtransactionTimestampBetween(Integer walletId, Date startDate, Date endDate, Pageable pageable);
    Page<Transactions> findByWalletIdAndtransactionTimestampAfter(Integer walletId, Date startDate,Pageable pageable);

}
