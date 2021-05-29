package com.demo.walet.transactionhistory.service;

import com.demo.walet.transactionhistory.models.entity.AccountStatements;
import com.demo.walet.transactionhistory.repo.StatementsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatementsService {
    private static final Pageable DEFAULT_PAGE_REQUEST= PageRequest.of(0,10, Sort.by("stmtDate").descending());
    @Autowired
    StatementsRepo repo;

    public List<AccountStatements> getStatements(Integer walletId){
        return repo.findByWalletId(walletId, DEFAULT_PAGE_REQUEST).getContent();
    }

    public AccountStatements getLatestStatement(Integer walletId){
        List<AccountStatements> statements= getStatements(walletId);
        if(statements!=null && !statements.isEmpty()){
            return statements.get(0);
        }
        return null;
    }
}
