package com.demo.walet.transactionhistory.api.advice;

import com.demo.walet.transactionhistory.models.dto.response.ErrorResponse;
import com.demo.walet.transactionhistory.util.exceptions.WalletException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
public class WalletControllerAdvice {

    @ExceptionHandler(value = WalletException.class)
    public ResponseEntity<ErrorResponse> walletException(WalletException e){
        log.error("exception -->",e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(e.getErrorCode(), e.getErrorMessage()));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> unknownException(Exception e){
        log.error("exception -->",e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(e.toString(), e.getLocalizedMessage()));
    }

    public ResponseEntity<ErrorResponse> validationException(MethodArgumentNotValidException e){
        log.error("exception -->", e);
        StringBuilder message=new StringBuilder();
        e.getBindingResult().getAllErrors().forEach(objectError -> {
            message.append(((FieldError)objectError).getField()).append(":")
                    .append(objectError.getDefaultMessage()).append(",");

        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("bad request",message.toString()));
    }
}
