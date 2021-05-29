package com.demo.walet.transactionhistory.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class BalanceResponse {
    private final Integer walletId;
    private final Double balance;
}
