package com.demo.walet.transactionhistory.service;

import com.demo.walet.transactionhistory.util.exceptions.WalletNotFoundException;

import java.util.Date;
import java.util.List;

public interface History {
    Double getCurrentBalance(Integer walletId) throws WalletNotFoundException;

    List getTransactionsBetween(Integer walletId, Date startDate, Date endDate);

    List getTransationTypeBetween(Integer walletId, Integer transactionType, Date startDat, Date endDate);
}
