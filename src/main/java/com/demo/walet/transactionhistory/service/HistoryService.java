package com.demo.walet.transactionhistory.service;

import com.demo.walet.transactionhistory.models.dto.PageInfo;
import com.demo.walet.transactionhistory.models.dto.TransactionView;
import com.demo.walet.transactionhistory.models.entity.AccountStatements;
import com.demo.walet.transactionhistory.models.entity.Transactions;
import com.demo.walet.transactionhistory.util.BeanConverter;
import com.demo.walet.transactionhistory.util.exceptions.WalletNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryService{

    @Autowired
    StatementsService statementsService;
    @Autowired
    TransactionsService transactionsService;
    @Autowired
    WalletsService walletsService;

    public Double getCurrentBalance(Integer walletId) throws WalletNotFoundException {
        AccountStatements lateststatement=statementsService.getLatestStatement(walletId);
        if(lateststatement==null){
            throw new WalletNotFoundException();
        }
        List<Transactions> transactions=transactionsService.getTransactionsAfter(walletId,lateststatement.getStmtDate());
        Double balance=lateststatement.getBalance();
        for(Transactions transaction: transactions){
            if(transaction.getTransactiontype()==0){
                balance=balance-transaction.getAmount();
            }else{
                balance=balance+transaction.getAmount();
            }
        }
        return balance;
    }


    public List<TransactionView> getTransationTypeBetween(Integer walletId, Date startDate, Date endDate,PageInfo pageInfo) {
        List<Transactions> transactions= transactionsService.getTransactionsBetween(walletId, startDate, endDate, pageInfo);
        List<TransactionView> transactionViews=transactions.stream().map(BeanConverter::convertToView).collect(Collectors.toList());
        return transactionViews;
    }




}
