package com.demo.walet.transactionhistory.models.dto.response;

import com.demo.walet.transactionhistory.models.dto.TransactionView;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@AllArgsConstructor
@Builder(toBuilder = true)
public final class TransactionHistoryResponse {

    private final Double latestBalance;
    private final List<TransactionView> transaction;
}
