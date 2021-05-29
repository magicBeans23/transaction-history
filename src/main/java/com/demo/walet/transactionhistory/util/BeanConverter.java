package com.demo.walet.transactionhistory.util;

import com.demo.walet.transactionhistory.models.dto.TransactionView;
import com.demo.walet.transactionhistory.models.entity.Transactions;

public class BeanConverter {
    public static TransactionView convertToView(Transactions transactions){
        if(transactions==null)
            return new TransactionView(null, null, null, null);
        String transactionType=transactions.getTransactiontype()==0?"debit":"credit";

        return TransactionView.builder()
                .transactionId(transactions.getTransactionId())
                .transactiontype(transactionType)
                .amount(transactions.getAmount())
                .transactionTimestamp(transactions.getTransactionTimestamp()).build();

    }
}
