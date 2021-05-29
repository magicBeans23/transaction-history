package com.demo.walet.transactionhistory.util.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Data
public class WalletException extends Exception{
    private final String errorMessage;
    private final String errorCode;
}
