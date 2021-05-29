package com.demo.walet.transactionhistory.api.controller;

import com.demo.walet.transactionhistory.models.dto.TransactionView;
import com.demo.walet.transactionhistory.models.dto.request.TransactionHistoryRequest;
import com.demo.walet.transactionhistory.models.dto.response.BalanceResponse;
import com.demo.walet.transactionhistory.models.dto.response.TransactionHistoryResponse;
import com.demo.walet.transactionhistory.models.entity.Transactions;
import com.demo.walet.transactionhistory.service.HistoryService;
import com.demo.walet.transactionhistory.util.exceptions.WalletNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("transactions/v1/history")
@Slf4j
public class TranHistoryController {

    @Autowired
    HistoryService historyService;

    @GetMapping(value = "balance", name="get wallet balance", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BalanceResponse> getBalance(@PathVariable Integer walletId) throws WalletNotFoundException {
        MDC.put("request_reference",""+System.currentTimeMillis());
        Double balance=historyService.getCurrentBalance(walletId);
        BalanceResponse response=new BalanceResponse(walletId,balance);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping(value="transactions", name="get transactions for wallet", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionHistoryResponse> getTransactions(@RequestBody @Valid TransactionHistoryRequest request) throws WalletNotFoundException {
        MDC.put("request_reference",""+System.currentTimeMillis());
        Double balance=historyService.getCurrentBalance(request.getWalletId());
        List<TransactionView> transactions=historyService.getTransationTypeBetween(request.getWalletId(), request.getStartDate(), request.getEndDate(), request.getPageInfo());

        TransactionHistoryResponse response=new TransactionHistoryResponse(balance, transactions);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
