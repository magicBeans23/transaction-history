package com.demo.walet.transactionhistory.models.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class BalanceRequest {
    @NotNull
    @Positive
    private Integer walletId;
}
