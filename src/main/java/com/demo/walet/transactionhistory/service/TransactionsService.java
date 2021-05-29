package com.demo.walet.transactionhistory.service;

import com.demo.walet.transactionhistory.models.dto.PageInfo;
import com.demo.walet.transactionhistory.models.entity.Transactions;
import com.demo.walet.transactionhistory.repo.TransactionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionsService {

    private static final Pageable DEFAULT_PAGE_REQUEST=PageRequest.of(0,10, Sort.by("transactionTimestamp").descending());
    @Autowired
    TransactionsRepo repo;

    public List<Transactions> getTransactionsAfter(Integer walletId, Date startDate){
        return repo.findByWalletIdAndtransactionTimestampAfter(walletId, startDate, DEFAULT_PAGE_REQUEST).getContent();
    }

    public List<Transactions> getTransactionsBetween(Integer waletId, Date startDate, Date endDate, PageInfo pageInfo){
        //not using the page info, should be used to build pageable here.
        return repo.findByWalletIdAndtransactionTimestampBetween(waletId, startDate, endDate, DEFAULT_PAGE_REQUEST).getContent();

    }

}
