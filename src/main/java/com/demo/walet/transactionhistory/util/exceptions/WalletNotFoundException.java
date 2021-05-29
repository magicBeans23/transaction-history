package com.demo.walet.transactionhistory.util.exceptions;


public class WalletNotFoundException extends WalletException{

    public WalletNotFoundException(){
        super("requested  not found","invalid request");
        this.errorMessage="requested  not found";
        this.errorCode="invalid request";
    }
    private final String errorMessage;
    private final String errorCode;
}
