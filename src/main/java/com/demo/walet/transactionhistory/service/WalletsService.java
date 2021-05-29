package com.demo.walet.transactionhistory.service;

import com.demo.walet.transactionhistory.repo.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class WalletsService {

    private static Pageable DEFAULT_PAGE_REQUEST= PageRequest.of(0,1, Sort.by("transactionTimestamp").descending());
    @Autowired
    WalletRepo repo;
}
